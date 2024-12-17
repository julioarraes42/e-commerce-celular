package julio.br.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(

    Long id,

    @NotBlank(message = "O campo username não pode estar nulo")
    String username,

    @NotBlank(message = "O campo senha não pode estar nulo")
    String senha
) { }
