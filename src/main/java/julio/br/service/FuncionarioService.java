package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.FuncionarioDTO;
import julio.br.dto.FuncionarioResponseDTO;
import julio.br.dto.UsuarioResponseDTO;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);

    public void update(Long id, FuncionarioDTO dto);

    public void delete(Long id);

    public List<FuncionarioResponseDTO> findAll(int page, int pageSize);

    public UsuarioResponseDTO login(AutorizacaoUsuarioDTO dto);

    public void alterarSenha(String senhaAntiga, String senhaNova);

    public void validarLogin(String login, String senha);

    public void validarSenha(String senha);

    public long count();
}
