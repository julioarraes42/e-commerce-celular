package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Processador;

@ApplicationScoped
public class ProcessadorRepository implements PanacheRepository<Processador> {

    public PanacheQuery<Processador> findByMarca(String marca) {
        if (marca == null) {
            return null;
        }
        return find("UPPER(marca) LIKE ?1", marca.toUpperCase() + "%");
    }
}
