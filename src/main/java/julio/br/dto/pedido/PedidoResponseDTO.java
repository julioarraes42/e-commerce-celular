package julio.br.dto.pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import julio.br.dto.ClienteResponseDTO;
import julio.br.dto.VendaResponseDTO;
import julio.br.model.pedido.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    LocalDateTime dataPedido,
    String valorTotal,
    List<ItemPedidoResponseDTO> itens
) {
    // public static PedidoResponseDTO valueOf(Pedido pedido) {
    //     System.out.println("Itens do Pedido: " + pedido.getItens());
    //     List<ItemPedidoResponseDTO> lista = pedido.getItens()
    //                                                .stream()
    //                                                .map(ItemPedidoResponseDTO::valueOf)
    //                                                .toList();
    //     return new PedidoResponseDTO(
    //         pedido.getId(),
    //         ClienteResponseDTO.valueOff(pedido.getCliente()), 
    //         pedido.getDataPedido(),
    //         "R$" + String.format("%.2f",pedido.getValorTotal())
    //     );
    // }
}
