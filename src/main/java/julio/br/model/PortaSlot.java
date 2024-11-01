package julio.br.model;

import jakarta.persistence.Entity;

@Entity
public class PortaSlot extends DefaultEntity {

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
