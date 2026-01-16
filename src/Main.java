import controller.TutorController;
import model.TutorManager;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {

        TutorManager manager = new TutorManager();
        manager.loadData();
        
        ConsoleView view = new ConsoleView();
        TutorController controller = new TutorController(manager, view);

        controller.start(); // start the app
    }
}
