package view;

import controller.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Busca extends JFrame {
    private JPanel JPPrincipal;
    private JTextField tfGramado;
    private JTextField tfCheckin;
    private JTextField tfCheckout;
    private JTextField tfHospedes;
    private JButton btnBuscar;
    private JPanel JPBuscar;
    private JPanel JPImagem;
    private JLabel lbImagem;

    public Busca() {
        setContentPane(JPPrincipal);
        setTitle("Airbnb | Locações");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);

        JPImagem.setVisible(false);

        ImageIcon lbImagemIcon = new ImageIcon("resources/buscar_escuro.png");
        lbImagem.setIcon(lbImagemIcon);
        lbImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbImagem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main main = Main.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date dataInicio = dateFormat.parse(tfCheckin.getText());
                    Date dataFim = dateFormat.parse(tfCheckout.getText());
                    main.getPedido().setDataInicio(dataInicio);
                    main.getPedido().setDataFim(dataFim);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

//                new Reserva();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon lbImagemHoverIcon = new ImageIcon("resources/buscar.png");
                lbImagem.setIcon(lbImagemHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbImagem.setIcon(lbImagemIcon);
            }
        });



        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(700, 500);
                JPImagem.setVisible(true);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        Busca busca = new Busca();
    }
}
