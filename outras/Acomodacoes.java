package outras;

// File: Acomodacoes.java
import java.util.ArrayList;
import java.util.List;

public class Acomodacoes {
    private List<Comodidades> comodidades;
    private int quantidade;

    public Acomodacoes() {
        this.comodidades = new ArrayList<>();
        this.quantidade = 0;
    }

    public List<Comodidades> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<Comodidades> comodidades) {
        this.comodidades = comodidades;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void addComodidade(Comodidades comodidade) {
        this.comodidades.add(comodidade);
    }

    @Override
    public String toString() {
        return "Acomodacoes{" +
                "comodidades=" + comodidades +
                ", quantidade=" + quantidade +
                '}';
    }
}
