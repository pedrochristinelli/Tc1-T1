package DTO;

import java.util.List;

public class VacinaDTO {
    private int codigo;
    private String nome;
    private double preco;
    private List<String> doencasProtegidas;
    private List<String> idadesDosagens;
    private float tempoDuracaoEfeitoEmAnos;

    public VacinaDTO(int codigo, String nome, double preco, List<String> doencasProtegidas, List<String> idadesDosagens, float tempoDuracaoEfeitoEmAnos) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.doencasProtegidas = doencasProtegidas;
        this.idadesDosagens = idadesDosagens;
        this.tempoDuracaoEfeitoEmAnos = tempoDuracaoEfeitoEmAnos;
    }

    public VacinaDTO() {
    }

    @Override
    public String toString() {
        return "Vacina" +
                "\nCodigo: " + codigo +
                "\nNome: '" + nome + '\'' +
                "\nPreco: " + preco +
                "\nDoencas Protegidas: " + doencasProtegidas +
                "\nIdades e Dosagens: " + idadesDosagens +
                "\nTempo de Duracao do Efeito em Anos: " + tempoDuracaoEfeitoEmAnos +
                ".\n";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<String> getDoencasProtegidas() {
        return doencasProtegidas;
    }

    public void setDoencasProtegidas(List<String> doencasProtegidas) {
        this.doencasProtegidas = doencasProtegidas;
    }

    public List<String> getIdadesDosagens() {
        return idadesDosagens;
    }

    public void setIdadesDosagens(List<String> idadesDosagens) {
        this.idadesDosagens = idadesDosagens;
    }

    public float getTempoDuracaoEfeitoEmAnos() {
        return tempoDuracaoEfeitoEmAnos;
    }

    public void setTempoDuracaoEfeitoEmAnos(float tempoDuracaoEfeitoEmAnos) {
        this.tempoDuracaoEfeitoEmAnos = tempoDuracaoEfeitoEmAnos;
    }
}
