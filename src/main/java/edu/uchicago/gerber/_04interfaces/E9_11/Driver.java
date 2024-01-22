package edu.uchicago.gerber._04interfaces.E9_11;

public class Driver {
    public static void main(String[] args) {
        Student student = new Student("Alice", 2000, "CS");
        Instructor instructor = new Instructor("Bob", 1960, 100_000);
        System.out.println(student);
        System.out.println(instructor);
    }
}
