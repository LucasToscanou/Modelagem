package outras;

public class FormularioDeSaida extends FormularioDeVistoria {
    // Atributos privados
    private String condicoesAcomodacao;
    private float custosAdicionais;

    // Construtor
    public FormularioDeSaida(Estadia estadia, java.util.Date data, String condicoesAcomodacao, float custosAdicionais) {
        super(estadia, data);
        this.condicoesAcomodacao = condicoesAcomodacao;
        this.custosAdicionais = custosAdicionais;
    }

    // Métodos Getter e Setter
    public String getCondicoesAcomodacao() {
        return condicoesAcomodacao;
    }

    public void setCondicoesAcomodacao(String condicoesAcomodacao) {
        this.condicoesAcomodacao = condicoesAcomodacao;
    }

    public float getCustosAdicionais() {
        return custosAdicionais;
    }

    public void setCustosAdicionais(float custosAdicionais) {
        this.custosAdicionais = custosAdicionais;
    }
}
