package model;
import outras.Anfitriao;
import outras.Residencia;

import java.util.Date;
import java.io.Serializable;

public class PedidoDeReserva implements Serializable{
    private static final long serialVersionUID = 1L;
    private String usuario;
    private String anfitriao;
    private Residencia residencia;
    private Date dataInicio;
    private Date dataFim;
    private StatusDeReserva statusReserva;
    private Pagamento pagamento;
    private Integer qtdHospedes;
    // Construtor
    public PedidoDeReserva(String usuario){
        this.usuario = usuario;
    }

    // Método para confirmar a reserva
    public boolean confirmarReserva() {
        atualizarStatus(StatusDeReserva.ACEITO_PELO_ANFITRIAO);
        return true; // Retornando true para fins de exemplo
    }

    // Método para cancelar a reserva
    public boolean cancelarReserva() {
        atualizarStatus(StatusDeReserva.RECUSADO_PELO_ANFITRIAO);
        return true; // Retornando true para fins de exemplo
    }

    // Método para atualizar o status da reserva
    public void atualizarStatus(StatusDeReserva novoStatus) {
        this.statusReserva = novoStatus;
    }

    // Método para calcular o preço da estadia
    public Float calcularPreco() {
        // Residencia residencia, Estadia estadia
        float diaria = 100;
        int dias = 5;

        return dias*diaria; // Retornando 0.0f para fins de exemplo
    }



    // Getter and Setter for usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter and Setter for anfitriao
    public String getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(String anfitriao) {
        this.anfitriao = anfitriao;
    }

    // Getter and Setter for residencia
    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    // Getter and Setter for dataInicio
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    // Getter and Setter for dataFim
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    // Getter and Setter for statusReserva
    public StatusDeReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusDeReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    // Getter and Setter for pagamento
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Integer getQtdHospedes() {
        return qtdHospedes;
    }
    public void setQtdHospedes(Integer qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }
}
