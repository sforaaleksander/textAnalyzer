package com.codecool.text_analyzer.iterators;

import com.codecool.text_analyzer.content.FileContent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CharIterator extends Readable implements Iterator<String> {
    private final List<String> chars;
    private final FileContent fileContent;
    private int index;

    public CharIterator(FileContent fileContent) {
        this.fileContent = fileContent;
        this.chars = getCharsFromFile();
    }

    private List<String> getCharsFromFile() {
        String content = getFileContent(this.fileContent.getFileName());
        List<String> result = new ArrayList<>();
        for (char ch : content.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.add(Character.toString(ch).toLowerCase());
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return index < chars.size();
    }

    @Override
    public String next() {
        if (this.hasNext()) {
            return chars.get(index++);
        }
        return null;
    }
}
