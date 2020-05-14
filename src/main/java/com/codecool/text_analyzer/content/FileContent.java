package com.codecool.text_analyzer.content;

import com.codecool.text_analyzer.iterators.CharIterator;
import com.codecool.text_analyzer.iterators.WordIterator;

import java.util.Iterator;


public class FileContent implements IterableText {

    private final String fileName;

    public FileContent(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }

    @Override
    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }

    public String getFileName() {
        return fileName;
    }
}
