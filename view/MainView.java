package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainView() {
        setTitle("StayHub");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // Cria o CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adiciona os painéis ao CardLayout
        mainPanel.add(new HomePanel(this), "Home");
        mainPanel.add(new BuscaPanel(this), "Busca");

        // Mostra automaticamente a Home ao iniciar
        cardLayout.show(mainPanel, "Home");

        // Adiciona o mainPanel à janela principal
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método para mostrar a Home (se necessário em outras partes do código)
    public void mostrarHome() {
        cardLayout.show(mainPanel, "Home");
    }

    public void mostrarBusca() {
        cardLayout.show(mainPanel, "Busca");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView();
            }
        });
    }
}
