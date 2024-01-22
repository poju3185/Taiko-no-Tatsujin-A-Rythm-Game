package edu.uchicago.gerber._04interfaces.P9_6;

public class Daily extends Appointment{
    public Daily(String description, int year, int month, int day) {
        super(description, year, month, day);
    }
    public boolean occursOn(int year, int month, int day){
        int[] date = super.getDate();
        if (year < date[0]) return false;
        if (year > date[0]) return true;
        if (month > date[1]) return true;
        return month == date[1] && day >= date[2];
    }
}
