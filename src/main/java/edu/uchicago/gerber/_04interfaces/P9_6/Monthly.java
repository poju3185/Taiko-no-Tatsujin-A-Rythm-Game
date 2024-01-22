package edu.uchicago.gerber._04interfaces.P9_6;

public class Monthly extends Appointment{
    public Monthly(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    public boolean occursOn(int year, int month, int day){
        int[] date = super.getDate();
        if (year < date[0]) return false;
        if (year == date[0] && month < date[1]) return false;
        return day == date[2];
    }
}
