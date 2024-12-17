package julio.br.dto;

import julio.br.model.Cliente;
import julio.br.model.Funcionario;

public record UsuarioResponseDTO(
    Long id,
    String login,
    String senha
    ) {
    public static UsuarioResponseDTO valueOf(Cliente cliente) {
        return new UsuarioResponseDTO(
                cliente.getUsuario().getId(),
                cliente.getUsuario().getLogin(),
                cliente.getUsuario().getSenha());
    }

    public static UsuarioResponseDTO valueOf(Funcionario funcionario) {
        return new UsuarioResponseDTO(
                funcionario.getUsuario().getId(),
                funcionario.getUsuario().getLogin(),
                funcionario.getUsuario().getSenha());
    }
}
