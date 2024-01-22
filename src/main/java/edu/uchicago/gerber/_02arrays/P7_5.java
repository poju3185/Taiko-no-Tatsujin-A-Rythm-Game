package edu.uchicago.gerber._02arrays;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P7_5 {

    @Getter
    private int nRows;
    private String pathPrefix = "src/main/java/edu/uchicago/gerber/_02arrays/";
    private String filePath;
    private ArrayList<String> contentArray;

    public P7_5(String filePath) {
        this.filePath = this.pathPrefix + filePath;
        File fileInput = new File(this.filePath);
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println("There's been an error: " + e.getMessage());
            scanner.close();
        }
        this.contentArray = new ArrayList<>();
        this.nRows = 0;
        while (scanner.hasNextLine()) {
            this.contentArray.add(scanner.nextLine());
            this.nRows += 1;
        }
    }

    public void getContent() {
        for (String content : contentArray) {
            System.out.println(content);
        }
    }

    public int getNFields(int row) {
        String thisRow = contentArray.get(row);
        String[] columns = thisRow.split(",");
        return columns.length;
    }

    public String fields(int row, int column) {
        String thisRow = contentArray.get(row);
        String[] columns = thisRow.split(",");
        return columns[column];
    }

}


