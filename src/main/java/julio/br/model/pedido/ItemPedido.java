package julio.br.model.pedido;


import julio.br.model.DefaultEntity;



import jakarta.persistence.Entity;


@Entity
public class ItemPedido extends DefaultEntity {

    private Double subTotal;

    

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}