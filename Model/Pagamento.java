package Model;

import java.util.Date;

public class Pagamento {
    // Atributos privados
    private float valorDoPagamento;
    private Date data;
    private CartaoDeCredito cartao;
    private StatusDePagamento statusPagamento;

    // Construtor
    public Pagamento(float valorDoPagamento, Date data, CartaoDeCredito cartao, StatusDePagamento statusPagamento) {
        this.valorDoPagamento = valorDoPagamento;
        this.data = data;
        this.cartao = cartao;
        this.statusPagamento = statusPagamento;
    }

    // Métodos Getter e Setter
    public float getValorDoPagamento() {
        return valorDoPagamento;
    }

    public void setValorDoPagamento(float valorDoPagamento) {
        this.valorDoPagamento = valorDoPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public CartaoDeCredito getCartao() {
        return cartao;
    }

    public void setCartao(CartaoDeCredito cartao) {
        this.cartao = cartao;
    }

    public StatusDePagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusDePagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    // Método para processar o pagamento
    public boolean processarPagamento() {
        // Lógica para processar o pagamento (pode ser implementada posteriormente)
        return true; // Retornando true para fins de exemplo
    }

    // Método para atualizar o status do pagamento
    public void atualizarStatus(StatusDePagamento novoStatus) {
        this.statusPagamento = novoStatus;
    }
}
