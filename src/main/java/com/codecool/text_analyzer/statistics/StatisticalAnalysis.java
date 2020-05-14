package com.codecool.text_analyzer.statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticalAnalysis {
    private Iterator<String> iterator;


    public StatisticalAnalysis(Iterator iterator) {
        this.iterator = iterator;
    }

    public int countOf(String... words) {
        int totalOccurrences = 0;
        while (iterator.hasNext()) {
            if (Arrays.asList(words).contains(iterator.next())) {
                totalOccurrences++;
            }
        }
        return totalOccurrences;
    }

    public int dictionarySize() {
        Set<String> elements = new HashSet<>();
        while (iterator.hasNext()) {
            elements.add(iterator.next());
        }
        return elements.size();
    }

    public int size() {
        int total = 0;
        while (iterator.hasNext()) {
            iterator.next();
            total++;
        }
        return total;
    }


    public Set<String> occurMoreThan(Integer requiredPercentage) {
        Map<String, Integer> map = new HashMap<>();

        while (iterator.hasNext()) {
            String element = iterator.next();
            map.merge(element, 1, Integer::sum);
        }

        return map.entrySet().stream()
                .filter(a -> a.getValue() > requiredPercentage)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue))
                .keySet();

    }
}
