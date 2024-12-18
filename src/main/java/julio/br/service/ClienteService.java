package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
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
import julio.br.model.Venda;

public interface ClienteService {
    public ClienteResponseDTO create(@Valid ClienteDTO dto);

    public void update(Long id, ClienteDTO dto);

    public void delete(Long id);

    public void validarUsername(String username);

    public void validarCPF(String cpf);

    public void alterarSenha(String senhaAntiga, String senha);

    public void definirEndereco(Long idCliente, EnderecoDTO endereco);

    public void validarLogin(String login, String senha);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findAll(int page, int pageSize);

    public List<ClienteResponseDTO> findByNome(String nome, int page, int pageSize);

    public EnderecoResponseDTO findEndereco(Long id);

    public Long count();

    public UsuarioResponseDTO login(AutorizacaoUsuarioDTO dto);

    public Cliente dadosCliente();

    public List<Venda> dadosClienteVenda();

    public void validarSenha(String senha);

    public UsuarioResponseDTO login(String username, String senha);

    public void alterarSenha(AlterarSenhaDTO dto);

    public void alterarUsername(AlterarUsernameDTO dto);

    public void alterarEmail(AlterarEmailDTO dto);

    public ClienteResponseDTO findMeuPerfil();

}
