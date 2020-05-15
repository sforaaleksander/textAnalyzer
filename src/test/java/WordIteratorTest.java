import com.codecool.text_analyzer.content.FileContent;
import com.codecool.text_analyzer.controller.Controller;
import com.codecool.text_analyzer.display.View;
import com.codecool.text_analyzer.iterators.WordIterator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordIteratorTest {
    private static OutputStream outputStream;
    private WordIterator wordIterator;

    @BeforeAll
    static void setUp() {
        outputStream = new ByteArrayOutputStream();
    }

    @BeforeEach
    void init(){
        String[] args = {"test.txt"};
        FileContent fileContent = new FileContent(args[0]);
        PrintStream printStream = new PrintStream(outputStream);
        View view = new View(printStream);
        Controller controller = new Controller(args, view);
        controller.start();
        wordIterator = new WordIterator(fileContent);
    }

    @Test
    void numberOfChars() {
        assertEquals(7, wordIterator.getWords().size());
    }

}