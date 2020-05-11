import java.util.List;

public class CharIterator implements Iterator {
    private final List<String> letters;
    private int index;

    CharIterator(FileContent fileContent) {
        this.letters = fileContent.getLetters();
    }


    @Override
    public boolean hasNext() {
        return index < letters.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return letters.get(index++);
        } return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining() {

    }
}
