package edu.uchicago.gerber._07streams.E19_7;

import java.util.function.Function;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("abc", "e", "bdgkjlekjlw", "sf");
        Function<String, String> shortenWord = s -> s.charAt(0) + "..." + s.charAt(s.length()-1);
        stringStream.filter(s -> s.length() >= 2)
                .map(shortenWord)
                .forEach(System.out::println);

    }
}
