package julio.br.model;

public enum FormaPagamento {
    PIX("pix"),
    BOLETO("Boleto"),
    CARTÃO("Cartao");

    public String nome;

    private FormaPagamento(String nome) {
        this.nome = nome;
    }

}
