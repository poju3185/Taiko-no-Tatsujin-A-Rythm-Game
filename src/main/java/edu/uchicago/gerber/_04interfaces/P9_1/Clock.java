package edu.uchicago.gerber._04interfaces.P9_1;

public class Clock {
    protected String getHours() {
        String timeStr = new java.util.Date().toString();
        String[] parts = timeStr.split(" ");
        String time = parts[3];
        String[] timeParts = time.split(":");
        return timeParts[0];
    }

    protected String getMinutes() {
        String timeStr = new java.util.Date().toString();
        String[] parts = timeStr.split(" ");
        String time = parts[3];
        String[] timeParts = time.split(":");
        return timeParts[1];
    }

    public String getTime() {
        return getHours() + ":" + getMinutes();
    }
}
