package julio.br.model;

import jakarta.persistence.Entity;

@Entity
public class Camera extends DefaultEntity {

    private Float resolucao;
    private Boolean frontal;

    public Float getResolucao() {
        return resolucao;
    }

    public void setResolucao(Float f) {
        resolucao = f;
    }

    public Boolean getFrontal() {
        return frontal;
    }

    public void setFrontal(Boolean frontal) {
        this.frontal = frontal;
    }

}
