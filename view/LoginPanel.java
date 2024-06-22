package view;

import controller.Main;
import model.PedidoDeReserva;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private JTextField textFieldEmail;
    private JPasswordField passwordField;
    private JButton btnOK;
    private JButton btnCancelar;

    public LoginPanel() {
        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Panel for Fields with Margins
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(2, 2, 10, 10)); // Rows, Columns, HGap, VGap
        fieldsPanel.setBorder(new EmptyBorder(200, 200, 200, 200)); // Top, Left, Bottom, Right

        // Email Field
        JLabel lbEmail = new JLabel("Email:");
        textFieldEmail = new JTextField(20); // Fixed width
        fieldsPanel.add(lbEmail);
        fieldsPanel.add(textFieldEmail);

        // Password Field
        JLabel lbSenha = new JLabel("Senha:");
        passwordField = new JPasswordField(20); // Fixed width
        fieldsPanel.add(lbSenha);
        fieldsPanel.add(passwordField);

        add(fieldsPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center-aligned with gap

        // OK Button
        btnOK = new JButton("OK");
        btnOK.setPreferredSize(new Dimension(100, 30)); // Fixed size
        buttonsPanel.add(btnOK);

        // Cancel Button
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(100, 30)); // Fixed size
        buttonsPanel.add(btnCancelar);

        add(buttonsPanel, BorderLayout.SOUTH);

        // Action Listeners
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String senha = new String(passwordField.getPassword());

                // Example: Validate login credentials
                if (isValidLogin(email, senha)) {
                    // If valid, create PedidoDeReserva and dispose the panel
                    Main main = Main.getInstance();
                    main.createPedidoDeReserva(email);
                    JOptionPane.showMessageDialog(LoginPanel.this, "Login successful!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid credentials. Please try again.");
                    // Optionally: clearFields(); to reset input fields
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private boolean isValidLogin(String email, String senha) {
        // Replace with actual login validation logic
        return !email.isEmpty() && !senha.isEmpty();
    }

    private void clearFields() {
        textFieldEmail.setText("");
        passwordField.setText("");
    }

    // Optional: Getter methods for email and password fields

    public String getEmail() {
        return textFieldEmail.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180); // Adjusted size
        frame.setLocationRelativeTo(null); // Center on screen
        frame.add(new LoginPanel());
        frame.setVisible(true);
    }
}
