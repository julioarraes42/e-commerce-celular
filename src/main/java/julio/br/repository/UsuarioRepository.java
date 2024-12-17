package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Usuario;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Usuario findByNome(String login) {
        return find("login = ?1", login).firstResult();
    }

    public Usuario findByNomeAndSenha(String login, String senha) {
        return find("login = ?1 and senha = ?2", login, senha).firstResult();
    }

    public Usuario findById(Long id){
        return find("id", id).firstResult();
    }

}
