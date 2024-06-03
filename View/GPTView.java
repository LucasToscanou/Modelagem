package View;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GPTView extends JFrame {
    private JTextField textField = new JTextField(20);
    private JButton button = new JButton("Show Message");
    private JLabel label = new JLabel("Message: ");

    public GPTView() {
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);
        panel.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.add(panel);
    }

    public String getInputText() {
        return textField.getText();
    }

    public void setLabelText(String text) {
        label.setText("Message: " + text);
    }

    public void addButtonListener(ActionListener listenForButton) {
        button.addActionListener(listenForButton);
    }
}
