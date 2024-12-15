package julio.br.dto.pedido;

import java.util.List;

public record PedidoDTO(
    Long id_Cliente,
    String formaPagamento,
    List<ItemPedidoDTO> itens
) {
    
}
