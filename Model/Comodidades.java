package Model;

public class Comodidades {
    private String nome;
    private String descricao;

    public Comodidades(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Comodidades{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}