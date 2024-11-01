package julio.br.model;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venda extends DefaultEntity {

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<CelularVenda> celularVenda;

    private Float valorFinal;
    private LocalDateTime data;
    private FormaPagamento formaPagamento;

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<CelularVenda> getCelularVenda() {
        return celularVenda;
    }

    public void setCelularVenda(List<CelularVenda> celularVenda) {
        this.celularVenda = celularVenda;
    }

}
