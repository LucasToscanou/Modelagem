package Model;

import java.util.ArrayList;
import java.util.List;

public class Residencia {
    // Atributos
    private String endereco;
    private String descricao;
    private float precoPorNoite;
    private Anfitriao anfitriao;
    private List<Acomodacoes> acomodacoes;
    private List<TipoDeResidencia> tiposDeResidencia;

    // Construtor
    public Residencia(String endereco, String descricao, float precoPorNoite, Anfitriao anfitriao) {
        this.endereco = endereco;
        this.descricao = descricao;
        this.precoPorNoite = precoPorNoite;
        this.anfitriao = anfitriao;
        this.acomodacoes = new ArrayList<>();
        this.tiposDeResidencia = new ArrayList<>();
    }

    // Métodos Getter e Setter
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(float precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public Anfitriao getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Anfitriao anfitriao) {
        this.anfitriao = anfitriao;
    }

    public List<Acomodacoes> getAcomodacoes() {
        return new ArrayList<>(acomodacoes);
    }

    public List<TipoDeResidencia> getTiposDeResidencia() {
        return new ArrayList<>(tiposDeResidencia);
    }

    // Métodos para gerenciar acomodações
    public void addAcomodacoes(Acomodacoes acomodacao) {
        this.acomodacoes.add(acomodacao);
    }

    public void removeAcomodacoes(Acomodacoes acomodacao) {
        this.acomodacoes.remove(acomodacao);
    }

    // Método para atualizar tipo de residência
    public void atualizaTipoDeResidencia(TipoDeResidencia novoTipo) {
        this.tiposDeResidencia.add(novoTipo);
    }
}
