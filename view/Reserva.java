package view;

import controller.Main;
import model.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class Reserva extends JFrame {
    private MainView mainView;
    private JLabel lbCustoReserva, lbTotal, lbCheckin, lbCheckout, lbHospedes, lbImagem, lbNoites, lbDiaria, lbSelecionar;
    private JPanel JPReservaPrincipal, JPReserva, JPResumo, JPConfirma, JPResumoPagamento;
    private JPanel JPImagemResumoPagamento, JPInformacoesPreco, JPNumeroCartao, JPValidade, JPCVV, JPValidadeCvv, JPDadosCliente;
    private JTextField tfNumeroCartao, tfValidade, tfCVV, tfNomeCliente, tfSobrenomeCliente, tfCPF;
    private JButton confirmarEPagarBtn;
    private JButton cancelarBtn;
    private JLabel lbTaxaDeLimpeza;
    private JLabel lbTaxaDeServico;
    private JButton moreHospedeBtn;
    private JButton lessHospedeBtn;
    private JTextField tfCheckin;
    private JTextField tfCheckout;
    private JButton changeDateBtn;

    private Date checkinDate;
    private Date checkoutDate;
    private Integer qtdHospedes;
    private Integer qtdDiaria;
    private Integer custoDiaria;
    private Integer custoTotal;
    private Integer taxaLimpeza;
    private Integer taxaServico;
    private Integer custoReserva;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva (MainView mainView) {
        this.mainView = mainView;

        setContentPane(JPReserva);
        setTitle("Airbnb | Reserva");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);

        ImageIcon lbImagemIcon = new ImageIcon("resources/acomodacao1.png");
        lbImagem.setIcon(lbImagemIcon);

        setVisible(true);

        Main main = Main.getInstance();
        PedidoDeReserva pedido = main.getPedido();

        this.checkinDate = pedido.getDataInicio();
        this.checkoutDate = pedido.getDataFim();
        this.qtdHospedes = pedido.getQtdHospedes();
        this.custoDiaria = 120;
        calcQtdDiaria();
        this.custoReserva = this.custoDiaria * this.qtdDiaria;
        this.taxaLimpeza = 50;
        this.taxaServico = 10;
        calcCustoTotal();

        tfCheckin.setText(dateFormat.format(this.checkinDate));
        tfCheckout.setText(dateFormat.format(this.checkoutDate));
        lbHospedes.setText(Integer.toString(this.qtdHospedes));

        tfValidade.setText("01/01/1999");

        lbDiaria.setText(this.custoDiaria.toString());
        lbNoites.setText(this.qtdDiaria.toString());
        lbCustoReserva.setText(this.custoReserva.toString());

        lbTaxaDeLimpeza.setText(this.taxaLimpeza.toString());
        lbTaxaDeServico.setText(this.taxaServico.toString());
        lbTotal.setText(this.custoTotal.toString());

        confirmarEPagarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        pedido.setDataInicio(dateFormat.parse(tfCheckin.getText()));
                        pedido.setDataFim(dateFormat.parse(tfCheckout.getText()));

                        if (main.isDateCollision(pedido.getDataInicio(), pedido.getDataFim())) {
                            JOptionPane.showMessageDialog(null, "Erro: Colisão de datas detectada. Por favor, escolha outras datas.", "Erro de Reserva", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        AdministradoraDeCredito administradora = new AdministradoraDeCredito("Visa");
                        CartaoDeCredito cartao = new CartaoDeCredito(
                                tfNumeroCartao.getText(),
                                tfNomeCliente.getText(),
                                dateFormat.parse(tfValidade.getText()),
                                tfCVV.getText(),
                                administradora
                        );
                        LocalDate localDate = LocalDate.now();
                        Date reservaDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Pagamento pagamento = new Pagamento(
                                120,
                                reservaDate,
                                cartao,
                                StatusDePagamento.PAGAMENTO_PENDENTE
                        );
                        pedido.setPagamento(pagamento);
                        pedido.setQtdHospedes(qtdHospedes);
                        main.writePedidoDeReservaToFile();

                        mostrarConfirmacao(mainView);


                    } catch (ParseException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        });

        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        Main main = Main.getInstance();

                        AdministradoraDeCredito administradora = new AdministradoraDeCredito("Visa");
                        CartaoDeCredito cartao = new CartaoDeCredito(
                                tfNumeroCartao.getText(),
                                tfNomeCliente.getText(),
                                dateFormat.parse(tfValidade.getText()),
                                tfCVV.getText(),
                                administradora
                        );
                        LocalDate localDate = LocalDate.now();
                        Date reservaDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Pagamento pagamento = new Pagamento(
                                120,
                                reservaDate,
                                cartao,
                                StatusDePagamento.PAGAMENTO_PENDENTE
                        );

                        main.getPedido().setPagamento(pagamento);

                    } catch (ParseException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        });

        moreHospedeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qtdHospedes++;
                lbHospedes.setText(qtdHospedes.toString());
            }
        });
        lessHospedeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(qtdHospedes > 0) {
                    qtdHospedes--;
                    lbHospedes.setText(qtdHospedes.toString());
                }
            }
        });

        changeDateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        checkinDate = dateFormat.parse(tfCheckin.getText());
                        checkoutDate = dateFormat.parse(tfCheckout.getText());

                        calcQtdDiaria();
                        calcCustoReserva();
                        calcCustoTotal();
                        lbNoites.setText(qtdDiaria.toString());
                        lbCustoReserva.setText(custoReserva.toString());
                        lbTotal.setText(custoTotal.toString());

                    } catch (ParseException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        });
    }

    private Integer dateDiff(String d1, String d2) {
        long diffInDays = -1;
        try {
            Date date1 = dateFormat.parse(d1);
            Date date2 = dateFormat.parse(d2);

            long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
            diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) diffInDays;
    }

    private void calcQtdDiaria(){
        this.qtdDiaria = this.dateDiff(
                dateFormat.format(this.checkoutDate),
                dateFormat.format(this.checkinDate)
        );
    }

    private void calcCustoTotal(){
        this.custoTotal = this.custoReserva + this.taxaServico + this.taxaLimpeza;
        ;  }

    private void calcCustoReserva(){
        this.custoReserva = this.custoDiaria * this.qtdDiaria;
    }

    private void mostrarConfirmacao(MainView mainView){
        ConfirmacaoReserva confirmacaoReserva = new ConfirmacaoReserva(mainView, this);
        confirmacaoReserva.setVisible(true);
        System.out.println(confirmacaoReserva.toString());
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Reserva().setVisible(true);
//            }
//        });
//    }
}
