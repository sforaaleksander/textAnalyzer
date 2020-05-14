package com.codecool.text_analyzer.display;

import java.util.Map;
import java.util.Set;

public class View {

    public void printDoubleMap(Map<String, Double> map, String title) {
        System.out.println(title);
        for (Map.Entry<String, Double> element : map.entrySet()) {
            System.out.print(String.format("%S : %.2f, ", element.getKey(), element.getValue()));
        }
        System.out.println("");
    }

    public void printInt(Integer number, String title) {
        System.out.println(title);
        System.out.println(number);
    }

    public void printDouble(Double number, String title) {
        System.out.println(title);
        System.out.println(number);
    }

    public void printString(String string, String title) {
        System.out.println(title);
        System.out.println(string);
    }

    public void printSet(Set<String> set, String title) {
        System.out.println(title);
        for (String element : set) {
            System.out.print(element + ", ");
        }
        System.out.println("");
    }

    public void displayNoArgsMessage() {
        System.out.println("Please provide at least one file name to analyze.");
    }

    public void printTime(double time) {
        System.out.println("Performance time: " + time);
    }
}
