package edu.uchicago.gerber._07streams.E19_5;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(toString(intStream, 3)); // Example usage
    }
    public static <T> String toString(Stream<T> stream, int n) {
        return stream
                .limit(n) // Limit to the first n elements
                .map(s -> s.toString()) // Convert each element to its string representation
                .collect(Collectors.joining(", ")); // Join them with a comma separator
    }
}
