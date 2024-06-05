package Model;
import outras.Anfitriao;
import outras.Estadia;
import outras.Residencia;

import java.util.Date;

public class PedidoDeReserva {
    // Atributos privados
    private Usuario usuario;
    private Anfitriao anfitriao;
    private Residencia residencia;
    private Date dataInicio;
    private Date dataFim;
    private StatusDeReserva statusReserva;
    private Pagamento pagamento;

    // Construtor
    public PedidoDeReserva(Usuario usuario, Anfitriao anfitriao, Residencia residencia, Date dataInicio, Date dataFim, StatusDeReserva statusReserva, Pagamento pagamento) {
        this.usuario = usuario;
        this.anfitriao = anfitriao;
        this.residencia = residencia;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.statusReserva = statusReserva;
        this.pagamento = pagamento;
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
}
