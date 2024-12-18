package julio.br.dto.pedido;

import julio.br.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
    Long id,
    String nome,
    Double preco,
    String subTotal
) {
    //     public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
    //         return new ItemPedidoResponseDTO(
    //         item.getCelular().getId(),
    //         item.getCelular().getNome(),
    //         item.getCelular().getPreco().doubleValue(),
    //         "R$" + String.format("%.2f", item.getSubTotal())
    //     );
    // }
}
