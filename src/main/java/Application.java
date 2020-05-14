import com.codecool.text_analyzer.controller.Controller;

public class Application {

    public static void main(String[] arg) {
        String[] args = {"dickens_great.txt", "malville_moby.txt"};
        Controller controller = new Controller(args);
        controller.start();
    }
}