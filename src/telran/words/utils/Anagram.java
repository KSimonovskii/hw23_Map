package telran.words.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Anagram {

    public static boolean isAnagram(String word, String part) {
        //TODO Homework;
        if (word == null
                || word.isEmpty()
                || part == null
                || part.isEmpty()) {
            return false;
        }
        Map<Character, Integer> mapWord = new TreeMap<>();
        String inputWord = word.toLowerCase();
        String inputPart = part.toLowerCase();
        for (int i = 0; i < inputWord.length(); i++) {
            char sym = inputWord.charAt(i);
            mapWord.merge(sym, 1, (count, value) -> count + value);
        }

        for (int i = 0; i < inputPart.length(); i++) {
            char sym = inputPart.charAt(i);
            Integer balance = mapWord.get(sym);
            if (balance == null || balance == 0) {
                return false;
            }
            mapWord.put(sym, --balance);
        }
        return true;
    }
}
