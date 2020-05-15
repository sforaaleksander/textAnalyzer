package com.codecool.text_analyzer.display;

import java.util.Map;
import java.util.Set;
import java.io.PrintStream;

public class View {
    private PrintStream printStream;

    public View(PrintStream printStream){
        this.printStream = printStream;
    }

    public void printDoubleMap(Map<String, Double> map, String title) {
        printStream.print(title);
        for (Map.Entry<String, Double> element : map.entrySet()) {
            printStream.print(String.format("%S : %.2f, ", element.getKey(), element.getValue()));
        }
        printStream.println();
    }

    public void printDouble(Double number, String title) {
        printStream.print(title);
        printStream.println(String.format("%.2f", number));
    }

    public void printInt(Integer number, String title) {
        printStream.print(title);
        printStream.println(number);
    }

    public void printString(String string, String title) {
        printStream.print(title);
        printStream.println(string);
    }

    public void printSet(Set<String> set, String title) {
        printStream.print(title);
        for (String element : set) {
            printStream.print(element + ", ");
        }
        printStream.println();
    }

    public void displayNoArgsMessage() {
        printStream.println("Please provide at least one file name to analyze.");
    }

    public void printTime(double time) {
        printStream.print("Performance time: " + time);
    }
}
