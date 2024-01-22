package edu.uchicago.gerber._07streams.P13_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneNumberSpelling {
    // Mapping from digits to letters
    private final Map<Character, String> PHONE_MAP = new HashMap<>();
    private final Set<String> dictionary;

    public PhoneNumberSpelling() {
        try {
            dictionary = Files.readAllLines(Paths.get("/usr/share/dict/words")).stream()
                    .map(String::toUpperCase).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PHONE_MAP.put('2', "ABC");
        PHONE_MAP.put('3', "DEF");
        PHONE_MAP.put('4', "GHI");
        PHONE_MAP.put('5', "JKL");
        PHONE_MAP.put('6', "MNO");
        PHONE_MAP.put('7', "PQRS");
        PHONE_MAP.put('8', "TUV");
        PHONE_MAP.put('9', "WXYZ");
    }

    // Public method to find all word combinations for a given phone number
    public List<String> findAllCombinations(String number) {
        List<String> results = new ArrayList<>();
        findCombinations(number, 0, "", results);
        return results;
    }

    // Helper method to recursively find all combinations
    // It tries to form words starting from different points in the number
    private void findCombinations(String number, int start, String currentCombo, List<String> results) {
        if (start == number.length()) {
            results.add(currentCombo.trim());
            return;
        }

        for (int i = start; i < number.length(); i++) {
            String segment = number.substring(start, i + 1);
            List<String> words = new ArrayList<>();
            generateWordsForSegment(segment, "", words);
            for (String word : words) {
                findCombinations(number, i + 1, currentCombo + " " + word, results);
            }
        }
    }

    // Method to generate all valid words for a given segment of the number
    private void generateWordsForSegment(String number, String word, List<String> result) {
        if (number.isEmpty()) {
            if (word.length() != 1 && dictionary.contains(word)) result.add(word);
            return;
        }
        char curNum = number.charAt(0);
        String letters = PHONE_MAP.get(curNum);
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            // Process each character
            if (number.length() == 1) {
                generateWordsForSegment("", word + ch, result);
            } else {
                generateWordsForSegment(number.substring(1), word + ch, result);
            }
        }


    }

}
