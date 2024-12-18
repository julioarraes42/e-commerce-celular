package julio.br.service;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import julio.br.dto.pedido.PedidoDTO;
import julio.br.dto.pedido.PedidoResponseDTO;
import julio.br.repository.ClienteRepository;
import julio.br.repository.ItemPedidoRepository;
import julio.br.repository.PedidoRepository;

public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ItemPedidoRepository itemPedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Override
    public List<PedidoResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCliente'");
    }

    @Override
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void cancelarPedido(Long idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPedido'");
    }

    @Override
    public void finalizarPedido(Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarPedido'");
    }

    @Override
    public void pagamentoBoleto(Long idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagamentoBoleto'");
    }

    @Override
    public void pagamentoPix(Long idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagamentoPix'");
    }

    @Override
    public boolean clienteAutenticado(String username, Long idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clienteAutenticado'");
    }

    @Override
    public List<PedidoResponseDTO> meusPedidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'meusPedidos'");
    }
    
}
