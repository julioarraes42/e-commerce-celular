package julio.br.dto;

import java.time.LocalDate;

public record LinhaDTO(
                Long id,
                String nome,
                LocalDate anoLancamento) {
}
