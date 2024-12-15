package julio.br.model.formaPagamento;

import java.time.LocalDate;

import julio.br.model.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class FormaPagamento2 extends DefaultEntity{
     
    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Boolean confirmacaoPagamento;

    private LocalDate dataPagamento;

    public FormaPagamento2 (Double valor) {
        this.valor = valor;
        this.confirmacaoPagamento = true;
        this.dataPagamento = LocalDate.now();
    }

    public FormaPagamento2 () {
        this.confirmacaoPagamento = false;
    }

    public Boolean getConfirmacaoPagamento() {
        return confirmacaoPagamento;
    }

    public void setConfirmacaoPagamento(Boolean confirmacaoPagamento) {
        this.confirmacaoPagamento = confirmacaoPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
