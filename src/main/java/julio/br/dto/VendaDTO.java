package julio.br.dto;

import java.time.LocalDateTime;
import java.util.List;

import julio.br.model.FormaPagamento;

public record VendaDTO(
                List<CelularVendaDTO> celulares,
                LocalDateTime data,
                FormaPagamento formaPagamento) {

}
