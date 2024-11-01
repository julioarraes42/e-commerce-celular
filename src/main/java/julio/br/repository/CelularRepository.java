package julio.br.repository;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Camera;
import julio.br.model.Celular;
import julio.br.model.PortaSlot;
import julio.br.model.Processador;
import julio.br.model.Tela;

@ApplicationScoped
public class CelularRepository implements PanacheRepository<Celular> {

    public List<Celular> findByMarca(String marca) {
        return find("UPPER(marca) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }

    public List<Celular> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public Celular findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1", nome.toUpperCase()).firstResult();
    }

    public List<Celular> findByAnoLancamento(LocalDate anoLancamento) {
        return find("anoLancamento = ?1", anoLancamento).list();
    }

    public List<Celular> findByArmazenamento(Float armazenamento) {
        return find("armazenamento = ?1", armazenamento).list();
    }

    public List<Celular> findByRam(Float ram) {
        return find("ram = ?1", ram).list();
    }

    public List<Celular> findByPreco(Float preco) {
        return find("preco = ?1", preco).list();
    }

    public List<Celular> findByCamera(Camera camera) {
        return find("SELECT c FROM Celular c JOIN c.camera cam WHERE cam = ?1", camera).list();
    }

    public List<Celular> findByPortaSlot(PortaSlot portaSlot) {
        return find("SELECT c FROM Celular c JOIN c.portaSlot cam WHERE cam = ?1", portaSlot).list();
    }

    public List<Celular> findByProcessador(Processador processador) {
        return find("processador", processador).list();
    }

    public List<Celular> findByTela(Tela tela) {
        return find("tela", tela).list();
    }

}
