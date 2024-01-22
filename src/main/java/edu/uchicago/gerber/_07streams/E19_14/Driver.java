package edu.uchicago.gerber._07streams.E19_14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        String filePath = "src/main/java/edu/uchicago/gerber/_07streams/E19_14/War_and_Peace.txt";
        ArrayList<String> words = new ArrayList<>();

        try {
            // Read all lines from the file
            Files.lines(Paths.get(filePath))
                    // Split lines into words
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    // Filter out any empty strings
                    .filter(word -> !word.isEmpty())
                    // Add words to the ArrayList
                    .forEach(words::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Turn the ArrayList into a parallel stream
        // The result is different for every execution
         words.parallelStream()
                 .filter(s -> s.length() >= 5)
                 .filter(s-> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
                 .findAny()
                 .ifPresent(System.out::println);
    }
}
