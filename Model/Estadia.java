package Model;

import java.util.Date;

public class Estadia {
    // Atributos privados
    private PedidoDeReserva pedidoDeReserva;
    private Date checkIn;
    private Date checkOut;

    // Construtor
    public Estadia(PedidoDeReserva pedidoDeReserva, Date checkIn, Date checkOut) {
        this.pedidoDeReserva = pedidoDeReserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Métodos Getter e Setter
    public PedidoDeReserva getPedidoDeReserva() {
        return pedidoDeReserva;
    }

    public void setPedidoDeReserva(PedidoDeReserva pedidoDeReserva) {
        this.pedidoDeReserva = pedidoDeReserva;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    // Métodos para iniciar e finalizar a estadia
    public void iniciarEstadia() {
        this.checkIn = new Date(); // Define a data de check-in como a data atual
        System.out.println("Estadia iniciada");
    }
}