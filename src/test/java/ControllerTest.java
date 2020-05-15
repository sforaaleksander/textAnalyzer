import com.codecool.text_analyzer.controller.Controller;
import com.codecool.text_analyzer.display.View;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller controller;
    private static OutputStream outputStream;

    @BeforeAll
    static void initializeOutput(){
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    void fileNotFound() {
        String[] args = {"error.txt"};
        View view = new View(new PrintStream(outputStream));
        controller = new Controller(args, view);
        assertThrows(IllegalArgumentException.class, () ->controller.start());
    }

    @Test
    void anoFileGiven() {
        String[] args = {};
        View view = new View(new PrintStream(outputStream));
        controller = new Controller(args, view);
        controller.start();
        System.out.println(outputStream.toString());
        assertEquals("Please provide at least one file name to analyze.\n", outputStream.toString());
    }

    @Test
    void checkCorrectResult() {
        String[] args = {"test.txt"};
        View view = new View(new PrintStream(outputStream));
        controller = new Controller(args, view);
        controller.start();
        System.out.println(outputStream.toString());
        assertThat(outputStream.toString())
                .contains(
                "Letters count: 29",
                "Word count: 6",
                "Different words used: 6",
                "Words making up more than 1% of the text: pieca, hyc, spadlo, w, z, abecadlo, ",
                "'Love' count: 0",
                "'Hate' count: 0",
                "'Music' count: 0",
                "Vowels percentage: 2",
                "A : E ratio: 2.50",
                "Percantage usage for each letter: A : 17.24, B : 3.45, C : 10.34, D : 10.34, E : 6.90, F : 0.00, G : 0.00, H : 3.45, I : 6.90, J : 0.00, K : 0.00, L : 10.34, M : 3.45, N : 0.00, O : 6.90, P : 6.90, Q : 0.00, R : 0.00, S : 3.45, T : 0.00, U : 0.00, V : 0.00, W : 3.45, X : 0.00, Y : 3.45, Z : 3.45, ");
    }
}