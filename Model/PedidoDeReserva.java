package Model;
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
        // Lógica para confirmar a reserva (pode ser implementada posteriormente)
        return true; // Retornando true para fins de exemplo
    }

    // Método para cancelar a reserva
    public boolean cancelarReserva() {
        // Lógica para cancelar a reserva (pode ser implementada posteriormente)
        return true; // Retornando true para fins de exemplo
    }

    // Método para atualizar o status da reserva
    public void atualizarStatus(StatusDeReserva novoStatus) {
        this.statusReserva = novoStatus;
    }

    // Método para calcular o preço da estadia
    public Float calcularPreco(Residencia residencia, Estadia estadia) {
        // Lógica para calcular o preço da estadia (pode ser implementada posteriormente)
        return 0.0f; // Retornando 0.0f para fins de exemplo
    }
}
