package julio.br.dto;

import java.time.LocalDate;

import julio.br.model.Linha;

public record LinhaResponseDTO(
        Long id,
        String nome,
        LocalDate anoLancamento) {
    public static LinhaResponseDTO valuesOf(Linha linha) {
        return new LinhaResponseDTO(
            linha.getId(),
                linha.getNome(),
                linha.getAnoLancamento());
    }
}
