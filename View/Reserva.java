package View;

import outras.Acomodacoes;

import javax.swing.*;

public class Reserva extends JFrame {
    private JPanel JPReserva;
    private JPanel JPResumo;
    private JLabel lbCheckin;
    private JLabel lbCheckout;
    private JLabel lbHospedes;
    private JPanel JPConfirma;
    private JLabel lbImagem;
    private JPanel JPReservaPrincipal;
    private JPanel JPResumoPagamento;
    private JPanel JPImagemResumoPagamento;
    private JPanel JPInformacoesPreco;
    private JLabel lbNoites;
    private JLabel lbDiaria;
    private JLabel lbSelecionar;
    private JTextField tfNumeroCartao;
    private JPanel JPNumeroCartao;
    private JPanel JPValidade;
    private JPanel JPCVV;
    private JTextField tfValidade;
    private JTextField tfCVV;
    private JTextField tfNomeCliente;
    private JTextField tfSobrenomeCliente;
    private JTextField tfCPF;
    private JPanel JPValidadeCvv;
    private JPanel JPDadosCliente;
    private JButton confirmarEPagarButton;

    private int hospedes;
    private float checkin = 17/07/2024;

    public int getHospedes() {
        return hospedes;
    }

    public void setHospedes(int hospedes) {
        this.hospedes = hospedes;
    }

    public Reserva () {

        Acomodacoes acomodacao = new Acomodacoes();

        acomodacao.verificarDisponibilidade("01/07/2024", "18/07/2024", false);
        acomodacao.verificarDisponibilidade("22/07/2024", "31/07/2025", false);

        //System.out.println("Períodos indisponíveis: " + acomodacao.getPeriodosIndisponiveis());

        //System.out.println("\nTentativa de reserva:");
        //System.out.println("Reserva válida de 05/07/2024 a 12/07/2024: " + acomodacao.verificarDisponibilidade("05/07/2024", "12/07/2024", true));
        //System.out.println("Reserva inválida de 22/07/2024 a 25/07/2024: " + acomodacao.verificarDisponibilidade("22/07/2024", "25/07/2024", true));
        //System.out.println("Reserva válida de 19/07/2024 a 21/07/2024: " + acomodacao.verificarDisponibilidade("19/07/2024", "21/07/2024", true));

        setContentPane(JPReserva);
        setTitle("Airbnb | Reserva");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);

        ImageIcon lbImagemIcon = new ImageIcon("resources/acomodacao1.png");
        lbImagem.setIcon(lbImagemIcon);

        setVisible(true);
    }

}
