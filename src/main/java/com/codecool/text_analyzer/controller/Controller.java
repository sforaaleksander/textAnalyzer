package com.codecool.text_analyzer.controller;

import com.codecool.text_analyzer.content.FileContent;
import com.codecool.text_analyzer.display.View;
import com.codecool.text_analyzer.iterators.CharIterator;
import com.codecool.text_analyzer.iterators.WordIterator;
import com.codecool.text_analyzer.statistics.StatisticalAnalysis;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final String[] args;
    private final View view;
    private long startingTime;
    private StatisticalAnalysis charAnalysis;
    private StatisticalAnalysis wordAnalysis;

    public Controller(String[] args) {
        this.args = args;
        view = new View();
    }

    private static boolean areArgsValid(String[] args) {
        return args.length != 0;
    }

    public void start() {
        if (!areArgsValid(args)) {
            view.displayNoArgsMessage();
            return;
        }
        this.startingTime = System.nanoTime();
        for (String fileName : args) {
            checkIfFileExists(fileName);
            handleAnalysis(fileName);
        }
        displayPerformanceTime();
    }

    private void checkIfFileExists(String fileName) {
        File f = new File(fileName);
        if (!(f.exists() && !f.isDirectory())) {
            throw new IllegalArgumentException(fileName + " file does not exist");
        }
    }

    private void displayPerformanceTime() {
        long estimatedTime = System.nanoTime() - startingTime;
        double time = (double) estimatedTime / 1000000000.0;
        view.printTime(time);
    }

    private void handleAnalysis(String fileName) {
        FileContent text = new FileContent(fileName);

        WordIterator wordIterator = new WordIterator(text);
        CharIterator charIterator = new CharIterator(text);

        charAnalysis = new StatisticalAnalysis(charIterator);
        wordAnalysis = new StatisticalAnalysis(wordIterator);

        viewFileName(fileName);
        viewAllCharsCount();
        viewAllWordsCount();
        viewDictionary();
        viewMoreThanOnePercentWords();
        viewLoveCount();
        viewHateCount();
        viewMusicCount();
        viewVowelsPercentage();
        viewAERatio();
        viewPercentageForEachLetter();
    }

    private void viewAllWordsCount() {
        view.printInt(wordAnalysis.size(), "Word count: ");
    }

    private void viewAllCharsCount() {
        view.printInt(charAnalysis.size(), "Letters count: ");
    }

    private void viewVowelsPercentage() {
        String[] vowelsArr = "aeiouy".split("");
        int vowelsCount = charAnalysis.countOf(vowelsArr);
        int charsCount = charAnalysis.size();
        int vowelsPercentage = charsCount / vowelsCount;
        view.printInt(vowelsPercentage, "Vowels percentage: ");
    }

    private void viewLoveCount() {
        view.printInt(wordAnalysis.countOf("love"), "'Love' count: ");
    }

    private void viewHateCount() {
        view.printInt(wordAnalysis.countOf("hate"), "'Hate' count: ");
    }

    private void viewMusicCount() {
        view.printInt(wordAnalysis.countOf("music"), "'Music' count: ");
    }

    private void viewFileName(String fileName) {
        String formatted = String.format("== %s == \n", fileName);
        view.printString(formatted, "");
    }

    private void viewMoreThanOnePercentWords() {
        double onePercent = 0.01;
        int wordsCount = wordAnalysis.size();
        Double onePercentOfAllWords = onePercent * wordsCount;
        view.printSet(wordAnalysis.occurMoreThan(onePercentOfAllWords.intValue()),
                "Words making up more than 1% of the text");
    }

    private void viewDictionary() {
        view.printInt(wordAnalysis.dictionarySize(), "Different words used: ");
    }

    private void viewAERatio(){
        int aCount = charAnalysis.countOf("a");
        int eCount = charAnalysis.countOf("e");
        view.printDouble((double) aCount/eCount, "A : E ratio:");
    }

    private void viewPercentageForEachLetter() {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        int lettersCount = charAnalysis.size();
        Map<String, Double> lettersPercentages = new HashMap<>();
        for (String letter : alphabet) {
            int thisLetterCount = charAnalysis.countOf(letter);
            Double percentageOfLetter = (double) (thisLetterCount * 100) / lettersCount;
            lettersPercentages.put(letter, percentageOfLetter);
        }
        view.printDoubleMap(lettersPercentages, "Percantage usage for each letter: ");
    }
}
