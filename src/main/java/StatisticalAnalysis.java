import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticalAnalysis {
//    private final List<String> data;
    private Iterator iterator;
    private int dataSize;
    private final LinkedHashMap<String, Integer> occurrences;


    public StatisticalAnalysis(Iterator iterator) {
//        this.data = data;
        this.iterator = iterator;
        this.dataSize = 0;
        this.occurrences = new LinkedHashMap<>();
        sortOccurrences(setOccurrences());
    }

    private LinkedHashMap<String, Integer> setOccurrences() {
        LinkedHashMap<String, Integer> unsorted = new LinkedHashMap<>();
        while (iterator.hasNext()) {
            unsorted.merge(iterator.next(), 1, Integer::sum);
            dataSize += 1;
        }
        return unsorted;
    }

    private void sortOccurrences(LinkedHashMap<String, Integer> unsorted) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unsorted
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> occurrences.put(x.getKey(), x.getValue()));
    }

    public LinkedHashMap<String, Integer> getOccurrences() {
        return occurrences;
    }

    public int countOf(String... words) {
        int totalOccurrences = 0;
        for (String word : words) {
            totalOccurrences += occurrences.get(word);
        }
        return totalOccurrences;
    }

    public int dictionarySize() {
        return occurrences.size();
    }

    public int getDataSize() {
        return dataSize;
    }

    public Set<String> occurMoreThan(Integer requiredPercentage) {
        Set<String> occurrenceOver = new HashSet<>();
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            int percentage = entry.getValue() * 100 / dataSize;
            if (percentage > requiredPercentage) {
                occurrenceOver.add(entry.getKey());
            }
        }
        return occurrenceOver;
    }
}
