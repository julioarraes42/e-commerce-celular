package julio.br.dto.pedido;

public record ItemPedidoResponseDTO(
    Long id,
    String nome,
    Double preco,
    String subTotal
) {
}
