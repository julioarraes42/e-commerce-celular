package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Tela;

@ApplicationScoped
public class TelaRepository implements PanacheRepository<Tela> {

        public PanacheQuery<Tela> findByTamanho(Float tamanho) {
        if (tamanho == null) {
            return null;
        }
        return find("tamanho = ?1", tamanho);
    }

    // public PanacheQuery<Tela> findAllPaginado() {
    //     return findAll();
    // }

}