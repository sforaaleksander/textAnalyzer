import com.codecool.text_analyzer.content.FileContent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileContentTest {
    private static FileContent fileContent;

    @BeforeEach
    void setUp(){
        String fileName = "test.txt";
        fileContent = new FileContent(fileName);
    }

    @Test
    void getFileName(){
        assertEquals("test.txt", fileContent.getFileName());
    }

    @Test
    void getCharIterator(){
        assertEquals("CharIterator", fileContent.charIterator().getClass().getSimpleName());
    }

    @Test
    void getWordIterator(){
        assertEquals("WordIterator", fileContent.wordIterator().getClass().getSimpleName());
    }
}