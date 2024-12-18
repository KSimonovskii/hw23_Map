package telran.map;

import java.util.*;

public class WordFrequencyAppl {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "limn", "limn", "ab", "limn", "a"};
        printWordFrequency(words);
    }

    private static void printWordFrequency(String[] words){
        Map<String, Integer> res = new HashMap<>();
        for (String word: words) {
//            if(res.putIfAbsent(word, 1) != null){
//                res.put(word, res.get(word) + 1);
//            }
//            res.computeIfPresent(word, (k, v) -> v + 1);
//            res.computeIfAbsent(word, k -> 1);

            res.merge(word, 1, (oldValue, value) -> oldValue + value);

        }
        System.out.println("==== Unsorted ====");
        Set<Map.Entry<String, Integer>> entries = res.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("==== Sorted by frequency (desc) ====");
        //TODO Homework desc
        Comparator<Map.Entry<String, Integer>> comparator = (i1, i2) -> {
            int resCompare = Integer.compare(i2.getValue(), i1.getValue());
            return resCompare == 0? i1.getKey().compareTo(i2.getKey()): resCompare;
        };
        SortedSet<Map.Entry<String, Integer>> wordSet = new TreeSet<>(comparator);
        wordSet.addAll(entries);

        for (Map.Entry<String, Integer> entry: wordSet) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
