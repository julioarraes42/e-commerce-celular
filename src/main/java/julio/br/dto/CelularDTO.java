package julio.br.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record CelularDTO(
        Long idTela,

        List<Long> idCamera,

        List<Long> idPortaSlot,

        List<Long> idSensor,

        Long idProcessador,

        Long idSerie,

        @NotBlank(message = "A marca não pode ser nulo ou vazio") @Size(min = 4, max = 60, message = "O tamanho do nome deve possuir de 4 a 60 caracteres.") String marca,

        @NotBlank(message = "O nome não pode ser nulo ou vazio") @Size(min = 4, max = 60, message = "O tamanho do nome deve possuir de 4 a 60 caracteres.") String nome,

        @Past(message = "data invalida ") LocalDate anoLancamento,

        Float armazenamento,

        Float ram,

        Float preco) {

}
