package julio.br.service;

import java.util.List;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.FuncionarioDTO;
import julio.br.dto.FuncionarioResponseDTO;
import julio.br.dto.UsuarioResponseDTO;
import julio.br.model.Funcionario;
import julio.br.model.Usuario;
import julio.br.repository.FuncionarioRepository;
import julio.br.repository.UsuarioRepository;
import julio.br.validation.ValidationException;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public SecurityIdentity securityIdentity;

    @Inject
    public HashService hashService;

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.login());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));

        usuarioRepository.persist(usuario);

        Funcionario funcionario = new Funcionario();
        funcionario.setCep(dto.cep());
        funcionario.setCpf(dto.cpf());
        funcionario.setNome(dto.nome());
        funcionario.setCnpj(dto.cnpj());
        funcionario.setUsuario(usuario);

        funcionarioRepository.persist(funcionario);

        return FuncionarioResponseDTO.valueOff(funcionario);

    }

    @Override
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id);

        funcionario.setCep(dto.cep());
        funcionario.setCpf(dto.cpf());
        funcionario.setNome(dto.nome());
        funcionario.setCnpj(dto.cnpj());
        funcionario.getUsuario().setLogin(dto.login());
        funcionario.getUsuario().setSenha(dto.senha());

    }

    @Transactional
    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDTO> findAll(int page, int pageSize) {
        List<Funcionario> funcionarios = funcionarioRepository
                .findAllPaginado()
                .page(page, pageSize)
                .list();

        return funcionarios
                .stream()
                .map(e -> FuncionarioResponseDTO.valueOff(e)).toList();
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
        Funcionario funcionario = funcionarioRepository.findByloginAndSenha(dto.username(), hashSenha);
        return UsuarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void alterarSenha(String senhaAntiga, String senhaNova) {
        HashService hash = new HashServiceImpl();
        validarSenha(hash.getHashSenha(senhaAntiga));
        ((Funcionario) funcionarioRepository.findByNome(securityIdentity.getPrincipal().getName()))
                .getUsuario()
                .setSenha(hash.getHashSenha(senhaNova));
    }

    @Override
    public void validarSenha(String senha) {
        String senhaAntiga = ((Funcionario) funcionarioRepository.findByNome(securityIdentity.getPrincipal().getName()))
                .getUsuario()
                .getSenha();
        if (!senhaAntiga.equals(senha))
            throw new ValidationException("senha", "senha errada");
    }

    @Override
    public long count() {
        return funcionarioRepository.count();
    }

}
