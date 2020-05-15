import com.codecool.text_analyzer.content.FileContent;
import com.codecool.text_analyzer.controller.Controller;
import com.codecool.text_analyzer.display.View;
import com.codecool.text_analyzer.iterators.CharIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CharIteratorTest {

    private static OutputStream outputStream;
    private CharIterator charIterator;

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
        charIterator = new CharIterator(fileContent);
    }

    @Test
    void numberOfChars() {
        assertEquals(30, charIterator.getChars().size());
    }
}