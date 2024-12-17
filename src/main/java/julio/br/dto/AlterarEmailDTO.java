package julio.br.dto;

import jakarta.validation.constraints.NotBlank;

public record AlterarEmailDTO (

    @NotBlank(message = "senha não pode ser nulo")
    String senha,

    @NotBlank(message = "email não pode ser nulo" )
    String emailNovo
    
) {}
