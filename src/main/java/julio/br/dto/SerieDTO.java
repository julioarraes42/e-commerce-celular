package julio.br.dto;

import java.time.LocalDate;

public record SerieDTO(
                Long id,
                String nome,
                LocalDate anoLancamento,
                Long linha) {
}
