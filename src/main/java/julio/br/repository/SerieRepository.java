package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Serie;

@ApplicationScoped
public class SerieRepository implements PanacheRepository<Serie> {

}
