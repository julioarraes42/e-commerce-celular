package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Cliente;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente findByloginAndSenha(String login, String senha) {
        return find("usuario.login = ?1 AND usuario.senha = ?2", login, senha).firstResult();
    }

    public PanacheQuery<Cliente> findByNome(String nome) {
        if (nome == null) {
            return null;
        }
        return find("UPPER(nome) LIKE ?1", nome.toUpperCase() + "%");
    }

    // public PanacheQuery<Cliente> findAllPaginado() {
    //     return findAll();
    // }

}
