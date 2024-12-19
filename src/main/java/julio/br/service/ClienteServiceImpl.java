package julio.br.service;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.SecurityContext;
import julio.br.dto.AlterarEmailDTO;
import julio.br.dto.AlterarSenhaDTO;
import julio.br.dto.AlterarUsernameDTO;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.ClienteDTO;
import julio.br.dto.ClienteResponseDTO;
import julio.br.dto.EnderecoDTO;
import julio.br.dto.EnderecoResponseDTO;
import julio.br.dto.UsuarioResponseDTO;
import julio.br.model.Cliente;
import julio.br.model.Endereco;
import julio.br.model.Usuario;
import julio.br.model.Venda;
import julio.br.repository.ClienteRepository;
import julio.br.repository.EnderecoRepository;
import julio.br.repository.UsuarioRepository;
import julio.br.repository.VendaRepository;
import julio.br.validation.ValidationException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    public SecurityIdentity securityIdentity;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public VendaRepository vendaRepository;

    @Inject
    public SecurityContext securityContext;

    @Inject
    public EnderecoRepository enderecoRepository;

    @Inject
    public HashService hashService;

    @Inject
    private JsonWebToken tokenJwt;

    @Override
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        HashService hash = new HashServiceImpl();

        validarUsername(dto.login());
        validarCPF(dto.cpf());

        System.out.println(dto.toString());

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.login());
        usuario.setSenha(hash.getHashSenha(dto.senha()));

        usuarioRepository.persist(usuario);

        Cliente cliente = new Cliente();
        cliente.setCep(dto.cep());
        cliente.setCpf(dto.cpf());
        cliente.setNome(dto.nome());
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);

        return ClienteResponseDTO.valueOff(cliente);

    }

    @Override
    public void update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id);
        HashService hash = new HashServiceImpl();

        cliente.setCep(dto.cep());
        cliente.setCpf(dto.cpf());
        cliente.setNome(dto.nome());
        cliente.getUsuario().setLogin(dto.login());
        cliente.getUsuario().setSenha(hash.getHashSenha(dto.senha()));

    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteResponseDTO> findAll(int page, int pageSize) {
        List<Cliente> clientes = clienteRepository
                .findAll()
                .page(page, pageSize)
                .list();

        return clientes
                .stream()
                .map(e -> ClienteResponseDTO.valueOff(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome, int page, int pageSize) {
        List<Cliente> clientes = clienteRepository
                .findByNome(nome)
                .page(page, pageSize)
                .list();

        return clientes
                .stream()
                .map(e -> ClienteResponseDTO.valueOff(e))
                .toList();
    }

    @Override
    public void validarLogin(String login, String senha) {
        HashService hash = new HashServiceImpl();
        Usuario usuario = usuarioRepository.findByNome(login);

        if (usuario == null)
            throw new ValidationException("login", "usuario ou senha invalidos");
        else if (!usuario.getSenha().equals(senha))
            throw new ValidationException("login",
                    "usuario ou senha invalidos");
    }

    @Override
    public UsuarioResponseDTO login(AutorizacaoUsuarioDTO dto) {
        HashService hash = new HashServiceImpl();
        String senha = dto.senha();
        String hashSenha = hash.getHashSenha(senha);
        validarLogin(dto.username(), hashSenha);
        Cliente cliente = clienteRepository.findByloginAndSenha(dto.username(), hashSenha);
        return UsuarioResponseDTO.valueOf(cliente);
    }

    @Override
    public Cliente dadosCliente() {
        return ((Cliente) clienteRepository.findByNome(securityIdentity.getPrincipal().getName()));
    }

    @Override
    public List<Venda> dadosClienteVenda() {
        Long id = dadosCliente().getId();
        return vendaRepository.findByCliente(id);
    }

    @Override
    @Transactional
    public void alterarSenha(String senhaAntiga, String senhaNova) {
        HashService hash = new HashServiceImpl();
        validarSenha(hash.getHashSenha(senhaAntiga));
        ((Cliente) clienteRepository.findByNome(securityIdentity.getPrincipal().getName()))
                .getUsuario()
                .setSenha(hash.getHashSenha(senhaNova));
    }

    public static void main(String[] args) {
        HashService hash = new HashServiceImpl();
        System.out.println(hash.getHashSenha("12345"));
        System.out.println(hash.getHashSenha("54321"));
        System.out.println(hash.getHashSenha(""));
    }

    @Override
    public void validarUsername(String username) {
        Usuario usuario = usuarioRepository.findByNome(username);
        if (usuario != null) {
            throw new ValidationException("username", "login ja existente");
        }
    }

    @Override
    public void validarCPF(String cpf) {
        if (cpf.length() != 14)
            throw new ValidationException("cpf", "cpf invalido");
    }

    @Override
    public void validarSenha(String senha) {
        String senhaAntiga = ((Cliente) clienteRepository.findByNome(securityIdentity.getPrincipal().getName()))
                .getUsuario()
                .getSenha();
        if (!senhaAntiga.equals(senha))
            throw new ValidationException("senha", "senha errada");
    }

    @Override
    public Long count() {
        return clienteRepository.count();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        return ClienteResponseDTO.valueOff(cliente);
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        validarLogin(username, senha);
        Cliente cliente = clienteRepository.findByloginAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente);
    }

    @Override
    public void alterarSenha(AlterarSenhaDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senhaAntiga(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha antiga não confere - Executando ClienteServiceImpl_alterarSenha");
        }

        cliente.getUsuario().setSenha(hashService.getHashSenha(dto.novaSenha()));
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    public void alterarUsername(AlterarUsernameDTO dto) {

        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senha(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha incorreta - Executando ClienteServiceImpl_alterarUsername");
        }

        cliente.getUsuario().setLogin(dto.usernameNovo());
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    public void alterarEmail(AlterarEmailDTO dto) {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null || !hashService.verificandoHash(dto.senha(), cliente.getUsuario().getSenha())) {
            throw new ValidationException("senhaAntiga",
                    "Senha incorreta - Executando ClienteServiceImpl_alterarEmail");
        }

        cliente.getUsuario().setEmail(dto.emailNovo());
        usuarioRepository.persist(cliente.getUsuario());
    }

    @Override
    public ClienteResponseDTO findMeuPerfil() {
        Usuario usuario = usuarioRepository.findById(Long.valueOf(tokenJwt.getClaim("id").toString()));

        Cliente cliente = clienteRepository.findByIdUsuario(usuario.getId());

        if (cliente == null) {
            throw new ValidationException("Perfil",
                    "Cliente não encontrado - Executando ClienteServiceImpl_findMeuPerfil");
        }
        return ClienteResponseDTO.valueOff(cliente);
    }

}
