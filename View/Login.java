package View;

import Controller.Main;
import Model.PedidoDeReserva;
import Model.Usuario;
import outras.Anfitriao;
import outras.Residencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Login extends JFrame {

    private JPanel JPanelLogin1;
    private JLabel lbLogin;
    private JTextField textField1;
    private JLabel lbSenha;
    private JButton btnCancelar;
    private JLabel lbEmail;
    private JButton btnOK;
    private JPasswordField passwordField1;

    public Login() {

        setContentPane(JPanelLogin1);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoDeReserva pedido = createPedidoDeReserva();
                Main main = Main.getInstance();
                //main.(new Usuario(), new Anfitriao(), new Residencia(), pedido);
                new Principal(pedido);
                dispose();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private PedidoDeReserva createPedidoDeReserva() {
        String username = textField1.getText();
        String senha = new String(passwordField1.getPassword());
        String email = lbEmail.getText(); // Assuming lbEmail contains the email

        // Create the PedidoDeReserva object with some dummy data
        return new PedidoDeReserva("Reserva Info for: " + username);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
