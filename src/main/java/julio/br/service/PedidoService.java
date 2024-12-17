package julio.br.service;

import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.pedido.PedidoDTO;
import julio.br.dto.pedido.PedidoResponseDTO;

public interface PedidoService {

    public List<PedidoResponseDTO> findAll();
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findByCliente(Long idCliente);    
    public PedidoResponseDTO create(@Valid PedidoDTO dto);
    public void cancelarPedido(Long idCliente);
    public void finalizarPedido(Long idPedido);
    // public void pagamentoCartao(Long idCliente, cartaoCreditoDTO cartaoCreditoDTO);
    public void pagamentoBoleto(Long idCliente);
    public void pagamentoPix(Long idCliente);
    boolean clienteAutenticado(String username, Long idCliente);
    public List<PedidoResponseDTO> meusPedidos();
    
}
