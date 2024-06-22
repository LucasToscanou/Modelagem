// File: StatusDePagamento.java
package model;

public enum StatusDePagamento {
    PAGAMENTO_PENDENTE(1, "Pagamento Pendente"),
    AUTORIZACAO_PENDENTE(2, "Autorização Pendente"),
    REEMBOLSO_PENDENTE(3, "Reembolso Pendente"),
    PAGAMENTO_FALHOU(4, "Pagamento Falhou"),
    PAGAMENTO_CONFIRMADO(5, "Pagamento Confirmado");

    private final int codigo;
    private final String descricao;

    StatusDePagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
