package julio.br.dto.pedido;

import java.util.List;

import julio.br.dto.CelularVendaDTO;

public record ItemPedidoDTO(
    List<CelularVendaDTO> celulares
) {
    
}
