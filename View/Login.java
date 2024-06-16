package View;

import outras.Acomodacoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                new Principal();
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

    public static void main(String[] args) {
        Login login = new Login();
    }
}