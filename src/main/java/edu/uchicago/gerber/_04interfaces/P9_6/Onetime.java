package edu.uchicago.gerber._04interfaces.P9_6;

public class Onetime extends Appointment{
    public Onetime(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    public boolean occursOn(int year, int month, int day){
        int[] date = super.getDate();
        return year == date[0] && month == date[1] && day == date[2];
    }
}
