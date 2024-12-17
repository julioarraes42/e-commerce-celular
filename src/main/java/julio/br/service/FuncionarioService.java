package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.AlterarEmailDTO;
import julio.br.dto.AlterarSenhaDTO;
import julio.br.dto.AlterarUsernameDTO;
import julio.br.dto.AutorizacaoUsuarioDTO;
import julio.br.dto.FuncionarioDTO;
import julio.br.dto.FuncionarioResponseDTO;
import julio.br.dto.UsuarioResponseDTO;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto);

    public void update(Long id, FuncionarioDTO dto);

    public void delete(Long id);

    public List<FuncionarioResponseDTO> findAll(int page, int pageSize);

    public List<FuncionarioResponseDTO> findByNome(String nome, int page, int pageSize);

    public FuncionarioResponseDTO findById(Long id);

    public UsuarioResponseDTO login(AutorizacaoUsuarioDTO dto);

    public void alterarSenha(String senhaAntiga, String senhaNova);

    public void validarLogin(String login, String senha);

    public void validarSenha(String senha);

    public long count();

    public void alterarSenha(AlterarSenhaDTO dto);
    public void alterarUsername(AlterarUsernameDTO dto);
    public void alterarEmail(AlterarEmailDTO dto);

    public FuncionarioResponseDTO findMeuPerfil();
}
