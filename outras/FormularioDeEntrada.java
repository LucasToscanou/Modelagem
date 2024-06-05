package outras;

public class FormularioDeEntrada extends FormularioDeVistoria {
    // Atributos privados
    private String condicoesAcomodacao;

    // Construtor
    public FormularioDeEntrada(Estadia estadia, java.util.Date data, String condicoesAcomodacao, String comentarios) {
        super(estadia, data);
        this.condicoesAcomodacao = condicoesAcomodacao;
        this.comentarios = comentarios;
    }

    // Métodos Getter e Setter
    public String getCondicoesAcomodacao() {
        return condicoesAcomodacao;
    }

    public void setCondicoesAcomodacao(String condicoesAcomodacao) {
        this.condicoesAcomodacao = condicoesAcomodacao;
    }
}
