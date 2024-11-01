package julio.br.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record CelularDTO(
                TelaDTO tela,

                List<CameraDTO> camera,

                List<Long> idPortaSlot,

                List<Long> idSensor,

                ProcessadorDTO processador,

                SerieDTO serie,

                @NotBlank(message = "A marca não pode ser nulo ou vazio") @Size(min = 4, max = 60, message = "O tamanho do nome deve possuir de 4 a 60 caracteres.") String marca,

                @NotBlank(message = "O nome não pode ser nulo ou vazio") @Size(min = 4, max = 60, message = "O tamanho do nome deve possuir de 4 a 60 caracteres.") String nome,

                @Past(message = "data invalida ") LocalDate anoLancamento,

                Float armazenamento,

                Float ram,

                Float preco) {

}
