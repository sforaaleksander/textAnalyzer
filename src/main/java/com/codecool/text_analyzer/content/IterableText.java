package com.codecool.text_analyzer.content;

import java.util.Iterator;

public interface IterableText {
    Iterator<String> charIterator();

    Iterator<String> wordIterator();

}
