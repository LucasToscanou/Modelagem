package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DanoNaEstadia {
    // Atributos privados
    private float valorDeRessarcimento;
    private Date dataDoOcorrido;
    private List<TaxaAdicional> taxaAdicional;
    private List<Foto> fotos;

    // Construtor
    public DanoNaEstadia(float valorDeRessarcimento, Date dataDoOcorrido) {
        this.valorDeRessarcimento = valorDeRessarcimento;
        this.dataDoOcorrido = dataDoOcorrido;
        this.taxaAdicional = new ArrayList<>();
        this.fotos = new ArrayList<>();
    }

    // Métodos para adicionar e remover taxas adicionais
    public void addTaxaAdicional(TaxaAdicional taxaAdicional) {
        this.taxaAdicional.add(taxaAdicional);
    }

    public void removeTaxaAdicional(TaxaAdicional taxaAdicional) {
        this.taxaAdicional.remove(taxaAdicional);
    }

    // Método para obter a lista de taxas adicionais
    public List<TaxaAdicional> getTaxaAdicional() {
        return taxaAdicional;
    }

    // Métodos para adicionar e obter fotos
    public void addFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public List<Foto> getFoto() {
        return fotos;
    }
}
