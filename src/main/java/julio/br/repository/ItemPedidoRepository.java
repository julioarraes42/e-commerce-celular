package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import julio.br.model.Celular;
import julio.br.model.pedido.ItemPedido;

public class ItemPedidoRepository implements PanacheRepository<ItemPedido> {
    
    public ItemPedido findById(Long id) {
        return find("id", id).firstResult();
    }

    public ItemPedido findByCelular (Celular celular) {
        if (celular == null)
            return null;

        return find("FROM ItemPedido WHERE celular = ?1", celular).firstResult();
    }

    
}
