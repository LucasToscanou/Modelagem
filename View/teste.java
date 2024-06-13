package View;

import javax.swing.*;

public class teste extends JFrame{
    private JComboBox comboBox1;
    private JList list1;
    private JTextArea nTextArea;
    private JPanel JPanelInicial;
    private JScrollPane algo;
    private JLabel lbAlgo1;

    public teste () {
        setContentPane(JPanelInicial);
        setTitle("Tela2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new teste();
    }
}
