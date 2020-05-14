package com.codecool.text_analyzer.iterators;

import com.codecool.text_analyzer.content.FileContent;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WordIterator extends Readable implements Iterator<String> {

    private FileContent fileContent;
    private final List<String> words;
    private int index;

    public WordIterator(FileContent fileContent) {
        this.fileContent = fileContent;
        this.words = getWordsFromFile();
    }

    private List<String> getWordsFromFile() {
        String content = getFileContent(this.fileContent.getFileName());
        String[] words = content.trim().split("\\s+");
        // TODO
        return Arrays.stream(words).map(String::toLowerCase).collect(Collectors.toList());
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

    public int getWordsSize() {
        return words.size();
    }
}
