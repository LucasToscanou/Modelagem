package Model;

public enum TipoDeResidencia {
    APARTAMENTO(1, "Apartamento"),
    CASA(2, "Casa"),
    CHALE(3, "Chalé"),
    SOBRADO(4, "Sobrado"),
    ESTUDIO(5, "Estúdio"),
    VILA(6, "Vila");

    private final int codigo;
    private final String descricao;

    TipoDeResidencia(int codigo, String descricao) {
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

