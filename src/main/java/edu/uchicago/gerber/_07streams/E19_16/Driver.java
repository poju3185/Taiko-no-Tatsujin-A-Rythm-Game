package edu.uchicago.gerber._07streams.E19_16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        try {
            Map<Character, Double> map =Files.readAllLines(Paths.get("/usr/share/dict/words")).stream()
                    .collect(Collectors.groupingBy(word -> Character.toLowerCase(word.charAt(0)),
                            Collectors.averagingInt(String::length)));
            System.out.println(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
