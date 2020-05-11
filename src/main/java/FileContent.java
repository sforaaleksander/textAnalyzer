import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class FileContent implements IterableText {
    private final List<String> letters;
    private final List<String> words;

    FileContent(String fileName) {
        letters = new ArrayList<>();
        words = new ArrayList<>();
        readFile(fileName);
    }

    public List<String> getLetters() {
        return letters;
    }

    public List<String> getWords() {
        return words;
    }

    private void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                String word = scan.next().toUpperCase();
                for (char letter : word.toCharArray()) {
                    letters.add(Character.toString(letter));
                }
                words.add(word);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator charIterator() {
        return new CharIterator(this);
    }

    @Override
    public Iterator wordIterator() {
        return new WordIterator(this);
    }
}
