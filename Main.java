import Controller.GPTController;
import View.GPTView;

public class Main {
    public static void main(String[] args) {
        // Instantiate model objects
//        Model model = new Model();

        // Instantiate view objects
        GPTView view = new GPTView();

        // Instantiate controller and pass model and view
        GPTController controller = new GPTController();

        // Run the application
//        controller.run();

        System.out.println("Main rodando\n");
    }
}