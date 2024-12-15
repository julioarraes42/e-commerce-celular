package julio.br.model.pedido;

import julio.br.model.CelularVenda;
import julio.br.model.DefaultEntity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ItemPedido extends DefaultEntity {

    private Double subTotal;

    @OneToMany
    private List<CelularVenda> celularVenda;
    

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public List<CelularVenda> getCelularVenda() {
        return celularVenda;
    }

    public void setCelularVenda(List<CelularVenda> celularVenda) {
        this.celularVenda = celularVenda;
    }


}