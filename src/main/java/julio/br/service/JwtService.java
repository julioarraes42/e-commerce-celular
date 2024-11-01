package julio.br.service;

import julio.br.dto.UsuarioResponseDTO;

public interface JwtService {
    String generateJwtCliente(UsuarioResponseDTO dto);

    String generateJwtFuncionario(UsuarioResponseDTO dto);
}
