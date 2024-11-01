package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.ClienteDTO;
import julio.br.dto.ClienteResponseDTO;
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

    public void validarLogin(String login, String senha);

    public List<ClienteResponseDTO> findAll();

    public UsuarioResponseDTO login(AutorizacaoUsuarioDTO dto);

    public Cliente dadosCliente();

    public List<Venda> dadosClienteVenda();

    public void validarSenha(String senha);

}
