package edu.uchicago.gerber._02arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class E7_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathPrefix ="src/main/java/edu/uchicago/gerber/_02arrays/";
        System.out.println("Input file name: ");
        String fileName = pathPrefix + scanner.nextLine();
        System.out.println("Output file name: ");
        String outputFileName = pathPrefix + scanner.nextLine();
        File fileInput = new File(fileName);

        try {
            scanner = new Scanner(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println("There's been an error: " + e.getMessage());
            return;
        }

        int nRow = 1;
        ArrayList<String> outputArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            outputArray.add("/* " + nRow + " */ " + scanner.nextLine());
            nRow += 1;
        }
        try (FileWriter writer = new FileWriter(outputFileName)){
            for (String s : outputArray) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
