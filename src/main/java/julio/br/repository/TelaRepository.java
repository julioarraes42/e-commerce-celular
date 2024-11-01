package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Tela;

@ApplicationScoped
public class TelaRepository implements PanacheRepository<Tela> {

}
