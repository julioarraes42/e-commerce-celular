package julio.br.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import julio.br.model.Cliente;
import julio.br.model.DefaultEntity;
import julio.br.model.Venda;
import julio.br.model.formaPagamento.FormaPagamento2;

@Entity
public class Pedido extends DefaultEntity {

    private LocalDateTime dataPedido;

    private Double valorTotal = 0.0;

    private Boolean ifPedidoFeito = false;

    @OneToOne
    @JoinColumn(name = "id_formaPagamento", unique = true)
    private FormaPagamento2 formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itens;

    private List<Venda> vendas;

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getIfPedidoFeito() {
        return ifPedidoFeito;
    }

    public void setIfPedidoFeito(Boolean ifPedidoFeito) {
        this.ifPedidoFeito = ifPedidoFeito;
    }

    public FormaPagamento2 getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento2 formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}