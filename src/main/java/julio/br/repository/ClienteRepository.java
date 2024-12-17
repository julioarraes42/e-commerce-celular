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
    // return findAll();
    // }

    public PanacheQuery<Cliente> findAllPaginado(int pageIndex, int pageSize) {
        return findAll().page(pageIndex, pageSize);
    }

    public Cliente findByLogin(String login) {
        return find("usuario.login", login).firstResult();
    }

    public Cliente findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Cliente findByCpf(String cpf) {
        return find("cpf", cpf).firstResult();
    }

    public Cliente findByUsername(String username) {

        if (username == null){
            return null;
        }
        return find("usuario.username", username).firstResult();
    }

    public Cliente findByUsernameAndSenha(String username, String senha) {
        return find("usuario.username = ?1 AND usuario.senha = ?2", username, senha).firstResult();
    }

    public Cliente findByIdUsuario(Long idUsuario){
        return find("usuario.id", idUsuario).firstResult();
    }

}
