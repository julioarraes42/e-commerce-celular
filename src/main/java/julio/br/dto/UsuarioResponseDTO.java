package julio.br.dto;

import julio.br.model.Cliente;
import julio.br.model.Funcionario;

public record UsuarioResponseDTO(String login) {
    public static UsuarioResponseDTO valueOf(Cliente cliente) {
        return new UsuarioResponseDTO(
                cliente.getUsuario().getLogin());
    }

    public static UsuarioResponseDTO valueOf(Funcionario funcionario) {
        return new UsuarioResponseDTO(
                funcionario.getUsuario().getLogin());
    }
}
