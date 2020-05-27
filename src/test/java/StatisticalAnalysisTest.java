import com.codecool.text_analyzer.content.FileContent;
import com.codecool.text_analyzer.iterators.CharIterator;
import com.codecool.text_analyzer.statistics.StatisticalAnalysis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {
    private StatisticalAnalysis statisticalAnalysis;

    @BeforeEach
    void init(){
        String[] args = {"test.txt"};
        FileContent fileContent = new FileContent(args[0]);
        CharIterator charIterator = new CharIterator(fileContent);
        statisticalAnalysis = new StatisticalAnalysis(charIterator);
    }

    @Test
    void testCountOfA(){
        assertEquals(5, statisticalAnalysis.countOf("a"));
    }

    @Test
    void testDictionarySize(){
        assertEquals(15, statisticalAnalysis.dictionarySize());
    }

    @Test
    void testSize(){
        assertEquals(29, statisticalAnalysis.size());
    }

    @Test
    void testOccurMoreThan(){
        Set<String> set = new HashSet<>(Arrays.asList("a"));
        assertEquals(set, statisticalAnalysis.occurMoreThan(3));
    }

}