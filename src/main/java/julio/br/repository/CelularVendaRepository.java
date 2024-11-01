package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.CelularVenda;

@ApplicationScoped
public class CelularVendaRepository implements PanacheRepository<CelularVenda> {

}
