// File: Controller.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Add listeners to the view
        this.view.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Update the model based on the view's input
            model.setMessage(view.getInputText());

            // Update the view based on the model's data
            view.setLabelText(model.getMessage());
        }
    }
}
