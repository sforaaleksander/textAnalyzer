import com.codecool.text_analyzer.controller.Controller;
import com.codecool.text_analyzer.display.View;

import java.io.PrintStream;

public class Application {

    public static void main(String[] arg) {
        String[] args = {"dickens_great.txt", "malville_moby.txt", "test.txt"};
        PrintStream printStream = new PrintStream(System.out);
        View view = new View(printStream);
        Controller controller = new Controller(args, view);
        controller.start();
    }
}