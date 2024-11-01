package julio.br.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Celular extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_tela")
    private Tela tela;

    @ManyToOne
    @JoinColumn(name = "id_processador")
    private Processador processador;

    @ManyToOne
    @JoinColumn(name = "id_serie")
    private Serie serie;

    @ManyToMany
    private List<Camera> camera;

    @ManyToMany
    private List<PortaSlot> portaSlot;

    @ManyToMany
    private List<Sensor> sensor;

    private String marca;

    private String nome;

    private LocalDate anoLancamento;
    private Float armazenamento;
    private Float ram;
    private Float preco;
    private String nomeImagem;
    private int estoque;

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

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

    public Float getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(Float armazenamento) {
        this.armazenamento = armazenamento;
    }

    public Float getRam() {
        return ram;
    }

    public void setRam(Float ram) {
        this.ram = ram;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public List<Camera> getCamera() {
        return camera;
    }

    public void setCamera(List<Camera> camera) {
        this.camera = camera;
    }

    public List<PortaSlot> getPortaSlot() {
        return portaSlot;
    }

    public void setPortaSlot(List<PortaSlot> portaSlot) {
        this.portaSlot = portaSlot;
    }

    public List<Sensor> getSensor() {
        return sensor;
    }

    public void setSensor(List<Sensor> sensor) {
        this.sensor = sensor;
    }

}