package julio.br.model;

import jakarta.persistence.Entity;

@Entity
public class Tela extends DefaultEntity {

    private Float tamanho;

    private Float resolucao;

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public Float getResolucao() {
        return resolucao;
    }

    public void setResolucao(Float resolucao) {
        this.resolucao = resolucao;
    }

}
