package edu.uchicago.gerber._04interfaces.P9_6;

import lombok.Getter;

@Getter
public abstract class Appointment {
    private int[] date;
    private String description;
    public Appointment(String description, int year, int month, int day){
        this.description = description;
        date = new int[3];
        date[0] = year;
        date[1] = month;
        date[2] = day;
    }
    public abstract boolean occursOn(int year, int month, int day);
}
