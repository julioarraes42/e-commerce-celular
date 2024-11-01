package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Linha;

@ApplicationScoped
public class LinhaRepository implements PanacheRepository<Linha> {

}