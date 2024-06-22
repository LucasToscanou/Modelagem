package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {

    private MainView parentView;

    public HomePanel(MainView parentView) {
        this.parentView = parentView;

        setLayout(new BorderLayout());

        // Imagem da logo do aplicativo
        ImageIcon logoIcon = new ImageIcon("resources/logo_stayhub.png");

        // Redimensionar a imagem para caber no JPanel
        Image scaledImage = logoIcon.getImage().getScaledInstance(parentView.getWidth(), parentView.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(logoLabel, BorderLayout.CENTER);

        // Botão de login
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(new Login.LoginListener() {
                    @Override
                    public void onLoginSuccess() {
                        parentView.mostrarBusca();
                    }
                });
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnLogin);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
