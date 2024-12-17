package julio.br.dto;

import java.time.LocalDate;

import julio.br.model.Serie;

public record SerieResponseDTO(
        Long id,
        String nome,
        LocalDate anoLancamento,
        LinhaResponseDTO linha) {
    public static SerieResponseDTO valuesOf(Serie serie) {
        return new SerieResponseDTO(
            serie.getId(),
                serie.getNome(),
                serie.getAnoLancamento(),
                LinhaResponseDTO.valuesOf(serie.getLinha()));
    }
}
