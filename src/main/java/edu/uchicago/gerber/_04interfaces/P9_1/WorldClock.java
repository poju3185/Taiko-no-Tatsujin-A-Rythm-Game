package edu.uchicago.gerber._04interfaces.P9_1;

public class WorldClock extends Clock {
    private final int timeDifference;

    public WorldClock(int timeDifference) {
        this.timeDifference = timeDifference;
    }

    @Override
    protected String getHours() {
        int hours = Integer.parseInt(super.getHours()) +  timeDifference;
        hours = (hours + 24) % 24;
        return Integer.toString(hours);
    }
}
