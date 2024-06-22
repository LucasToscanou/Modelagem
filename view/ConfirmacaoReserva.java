package view;

import javax.swing.*;

public class ConfirmacaoReserva extends JFrame {
    MainView mainView;
    Reserva reserva;
    public ConfirmacaoReserva(MainView mainView, Reserva reserva) {
        this.mainView = mainView;
        this.reserva = reserva;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmação de Reserva");

        JLabel label = new JLabel("Seu pedido de reserva foi realizada com sucesso!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        getContentPane().add(label, java.awt.BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avisarEncerramento();
                reserva.dispose();

                dispose(); // Fechar a janela ao clicar em OK
            }
        });
        JPanel panel = new JPanel();
        panel.add(okButton);
        getContentPane().add(panel, java.awt.BorderLayout.SOUTH);

        // Set size of the JFrame explicitly
        setSize(400, 200); // Width: 400 pixels, Height: 200 pixels

        // Alternatively, you can use pack() to size based on contents
        // pack();

        setLocationRelativeTo(null); // Centralizar a janela na tela
    }

    public void avisarEncerramento(){
        this.mainView.mostrarHome();
    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConfirmacaoReserva().setVisible(true);
//            }
//        });
//    }
}
