package julio.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Venda;

@ApplicationScoped
public class VendaRepository implements PanacheRepository<Venda> {

    public List<Venda> findByCliente(Long idCliente) {
        return find("cliente.id = ?1", idCliente).list();
    }
}
