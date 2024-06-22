package view;

import controller.Main;
import model.PedidoDeReserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuscaPanel extends JPanel {
    private JTextField tfGramado;
    private JTextField tfCheckin;
    private JTextField tfCheckout;
    private JTextField tfHospedes;
    private JButton btnBuscar;
    private JPanel JPImagem;
    private JLabel lbImagem;
    MainView parentView;

    public BuscaPanel(MainView parentView) {
        setLayout(new BorderLayout());

        this.parentView = parentView;
        // Components initialization
        JPanel JPPrincipal = new JPanel();
        JPPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Setting margins

        tfGramado = new JTextField("Gramado", 20); // Example default value and size
        tfCheckin = new JTextField("01/07/2024", 10); // Example default value and size
        tfCheckout = new JTextField("10/07/2024", 10); // Example default value and size
        tfHospedes = new JTextField("2", 5); // Example default value and size
        btnBuscar = new JButton("Buscar");

        JPImagem = new JPanel(new GridBagLayout());
        JPImagem.setVisible(false);

        lbImagem = new JLabel();
        lbImagem.setIcon(new ImageIcon("resources/buscar_escuro.png"));
        lbImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbImagem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main main = Main.getInstance();
                PedidoDeReserva pedido = main.getPedido();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date dataInicio = dateFormat.parse(tfCheckin.getText());
                    Date dataFim = dateFormat.parse(tfCheckout.getText());

                    pedido.setDataInicio(dataInicio);
                    pedido.setDataFim(dataFim);
                    pedido.setQtdHospedes(Integer.parseInt(tfHospedes.getText()));

                    Reserva reserva = new Reserva(parentView);

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbImagem.setIcon(new ImageIcon("resources/buscar.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbImagem.setIcon(new ImageIcon("resources/buscar_escuro.png"));
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPImagem.setVisible(true);
                displayImage();
            }
        });

        // Adding components to JPPrincipal with constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPPrincipal.add(new JLabel("Onde:"), gbc);
        gbc.gridx = 1;
        JPPrincipal.add(new JLabel("Check-in:"), gbc);
        gbc.gridx = 2;
        JPPrincipal.add(new JLabel("Checkout:"), gbc);
        gbc.gridx = 3;
        JPPrincipal.add(new JLabel("Hóspedes:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JPPrincipal.add(tfGramado, gbc);
        gbc.gridx = 1;
        JPPrincipal.add(tfCheckin, gbc);
        gbc.gridx = 2;
        JPPrincipal.add(tfCheckout, gbc);
        gbc.gridx = 3;
        JPPrincipal.add(tfHospedes, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JPPrincipal.add(btnBuscar, gbc);

        // Adding JPImagem (example JPanel) to BorderLayout.CENTER
        add(JPPrincipal, BorderLayout.NORTH);
        add(JPImagem, BorderLayout.CENTER);
    }

    // Method to display image
    private void displayImage() {
        ImageIcon originalIcon = new ImageIcon("resources/buscar.png");
        Image originalImage = originalIcon.getImage();

        // Getting the available space and calculating the size with margins
        int width = getWidth() - 40; // Width with margins
        int height = getHeight() - 40; // Height with margins
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lbImagem.setIcon(new ImageIcon(scaledImage));

        JPImagem.removeAll(); // Clear the panel
        JPImagem.add(lbImagem); // Add the label with the image
        JPImagem.revalidate(); // Revalidate the panel
        JPImagem.repaint(); // Repaint the panel
    }

    // Optional: Add getter methods for text fields if needed

    public String getGramadoText() {
        return tfGramado.getText();
    }

    public String getCheckinText() {
        return tfCheckin.getText();
    }

    public String getCheckoutText() {
        return tfCheckout.getText();
    }

    public String getHospedesText() {
        return tfHospedes.getText();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BuscaPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500); // Adjust size to test image fitting
        frame.setLocationRelativeTo(null);
        frame.add(new BuscaPanel(new MainView()));
        frame.setVisible(true);
    }
}
