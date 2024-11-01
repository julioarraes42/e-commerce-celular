package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Processador;

@ApplicationScoped
public class ProcessadorRepository implements PanacheRepository<Processador> {

}
