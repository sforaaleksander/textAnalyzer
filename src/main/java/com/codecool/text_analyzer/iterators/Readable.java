package com.codecool.text_analyzer.iterators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Readable {
    public String getFileContent(String fileName) {
        String content = "";
        try {
            // TODO
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
