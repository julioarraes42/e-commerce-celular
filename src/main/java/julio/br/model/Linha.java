package julio.br.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Linha extends DefaultEntity {

    private String nome;

    private LocalDate anoLancamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
