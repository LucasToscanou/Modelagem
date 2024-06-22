package view;

import controller.Main;
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
    private boolean loginSuccessful;

    public Login(LoginListener loginListener) {
        this.loginSuccessful = false;

        add(JPanelLogin1);

        setContentPane(JPanelLogin1);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulating login success
                loginSuccessful = true;
                Main.getInstance().createPedidoDeReserva(textField1.getText());
                // Notify listener (callback)
                if (loginListener != null) {
                    loginListener.onLoginSuccess();
                }

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

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public interface LoginListener {
        void onLoginSuccess();
    }

    public static void main(String[] args) {
        // Example usage (not recommended to start UI directly in main method)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login(new LoginListener() {
                    @Override
                    public void onLoginSuccess() {
                        System.out.println("Login successful");
                    }
                });
            }
        });
    }
}
