package edu.uchicago.gerber._04interfaces.E9_11;

public class Student extends Person {
    private String major;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", yearOfBirth=" + getYearOfBirth() +
                ", major='" + major + '\'' +
                '}';
    }

    public Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }
}
