import java.util.List;

public class WordIterator implements Iterator {
    private final List<String> words;
    private int index;

    WordIterator(FileContent fileContent) {
        this.words = fileContent.getWords();
    }

    @Override
    public boolean hasNext() {
        return index < words.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return words.get(index++);
        } return null;
    }

    @Override
    public void remove() {
    }

    @Override
    public void forEachRemaining() {

    }
}
