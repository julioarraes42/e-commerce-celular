package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Funcionario;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario> {

    public Funcionario findByloginAndSenha(String login, String senha) {
        return find("usuario.login = ?1 AND usuario.senha = ?2", login, senha).firstResult();
    }

    public PanacheQuery<Funcionario> findByNome(String nome) {
        if (nome == null) {
            return null;
        }
        return find("UPPER(nome) LIKE ?1", nome.toUpperCase() + "%");
    }

    public PanacheQuery<Funcionario> findAllPaginado() {
        return findAll();
    }

    public PanacheQuery<Funcionario> findAllPaginado(int pageIndex, int pageSize) {
        return findAll().page(pageIndex, pageSize);
    }

    public Funcionario findByLogin(String login) {
        return find("usuario.login", login).firstResult();
    }

    public Funcionario findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Funcionario findByCpf(String cpf) {
        return find("cpf", cpf).firstResult();
    }

    public Funcionario findByUsername(String username) {

        if (username == null){
            return null;
        }
        return find("usuario.username", username).firstResult();
    }

    public Funcionario findByUsernameAndSenha(String username, String senha) {
        return find("usuario.username = ?1 AND usuario.senha = ?2", username, senha).firstResult();
    }

    public Funcionario findByIdUsuario(Long idUsuario){
        return find("usuario.id", idUsuario).firstResult();
    }


}
