package Model;

import java.util.Date;

public class FormularioDeVistoria {
    // Atributos privados
    protected Estadia estadia;
    protected Date data;
    protected String comentarios;

    // Construtor
    public FormularioDeVistoria(Estadia estadia, Date data) {
        this.estadia = estadia;
        this.data = data;
        this.comentarios = "";
    }

    // Métodos Getter e Setter
    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getComentarios() {
        return comentarios;
    }

    // Método para preencher o formulário com comentários
    public void preencherFormulario(String comentarios) {
        this.comentarios = comentarios;
    }
}
