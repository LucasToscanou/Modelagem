// File: TaxaAdicional.java
package outras;

public class TaxaAdicional {
    private String nomeTaxa;
    private String descricao;

    public TaxaAdicional(String nomeTaxa, String descricao) {
        this.nomeTaxa = nomeTaxa;
        this.descricao = descricao;
    }

    public String getNomeTaxa() {
        return nomeTaxa;
    }

    public void setNomeTaxa(String nomeTaxa) {
        this.nomeTaxa = nomeTaxa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TaxaAdicional{" +
                "nomeTaxa='" + nomeTaxa + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
