// File: StatusDeReserva.java
package Model;

public enum StatusDeReserva {
    PENDENTE_PELO_ANFITRIAO(1, "Pendente pelo Anfitrião"),
    ACEITO_PELO_ANFITRIAO(2, "Aceito pelo Anfitrião"),
    RECUSADO_PELO_ANFITRIAO(3, "Recusado pelo Anfitrião"),
    TEMPO_EXPIRADO_PELO_ANFITRIAO(4, "Tempo expirado pelo Anfitrião"),
    CANCELADO_PELO_HOSPEDE(5, "Cancelado pelo Hóspede"),
    CANCELADO_PELO_ANFITRIAO(6, "Cancelado pelo Anfitrião"),
    ESTADIA_CONFIRMADA(7, "Estadia Confirmada");

    private final int codigo;
    private final String descricao;

    StatusDeReserva(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
