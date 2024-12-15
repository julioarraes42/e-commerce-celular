package julio.br.dto.pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import julio.br.dto.ClienteResponseDTO;
import julio.br.dto.VendaResponseDTO;
import julio.br.model.Venda;
import julio.br.model.pedido.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    LocalDateTime dataPedido,
    String valorTotal,
    List<VendaResponseDTO> itens,
    String statusPagamento,
    LocalDate dataPagamento,
    String statusPedido
) {
    // public static PedidoResponseDTO valueOf(Pedido pedido) {
    //     System.out.println("Itens do Pedido: " + pedido.getVendas());
    //     List<VendaResponseDTO> lista = pedido.getVendas()
    //                                                .stream()
    //                                                .map(VendaResponseDTO::valueOf)
    //                                                .toList();
    //     return new PedidoResponseDTO(
    //         pedido.getId(),
    //         ClienteResponseDTO.valueOff(pedido.getCliente()), 
    //         pedido.getDataPedido(),
    //         "R$" + String.format("%.2f",pedido.getValorTotal()),
    //         lista,
    //         pedido.getFormaPagamento() != null ? 
    //             pedido.getFormaPagamento().getConfirmacaoPagamento() == true ? 
    //                             "Pagamento realizado" : "Pagamento não realizado" : null,
    //         pedido.getFormaPagamento() != null ?
    //             pedido.getFormaPagamento().getDataPagamento() : null,
    //         pedido.getIfPedidoFeito() == true ? "Compra concluída" : "Compra em andamento"
    //     );
    // }
}
