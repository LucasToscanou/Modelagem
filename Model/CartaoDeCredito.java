package Model;
import java.util.Date;

public class CartaoDeCredito {
    // Atributos privados
    private String numero;
    private String nomeNoCartao;
    private Date validade;
    private String cvv;
    private AdministradoraDeCredito administradora;

    // Construtor
    public CartaoDeCredito(String numero, String nomeNoCartao, Date validade, String cvv,
                           AdministradoraDeCredito administradora) {
        this.numero = numero;
        this.nomeNoCartao = nomeNoCartao;
        this.validade = validade;
        this.cvv = cvv;
        this.administradora = administradora;
    }

    // Método para validar o cartão de crédito
    public boolean validarCartao() {
        // Aqui você pode implementar a lógica para validar o cartão
        // Por exemplo, verificar se o número é válido, se a data de validade é futura,
        // etc.
        // Neste exemplo, só retornaremos true
        return true;
    }

    // Métodos getter e setter
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeNoCartao() {
        return nomeNoCartao;
    }

    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public AdministradoraDeCredito getAdministradora() {
        return administradora;
    }

    public void setAdministradora(AdministradoraDeCredito administradora) {
        this.administradora = administradora;
    }
}
