package edu.uchicago.gerber._03objects.P8_7;

import lombok.Getter;

import java.util.ArrayList;

public class ComboLock {
    private static final int MODULA = 40;
    private final int[] secrets;
    @Getter
    private int dial;
    private final ArrayList<Integer> tries;

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secrets = new int[]{secret1, secret2, secret3};
        tries = new ArrayList<>();
        this.dial = 0;
    }

    public void reset() {
        dial = 0;
    }

    public void turnRight(int ticks) {
        if (ticks >= MODULA || ticks < 0) {
            System.out.println("error, invalid ticks");
            return;
        }
        dial = (dial + ticks) % MODULA;
        tries.add(dial);
    }

    public void turnLeft(int ticks) {
        if (ticks >= MODULA || ticks < 0) {
            System.out.println("error, invalid ticks");
            return;
        }
        dial = (dial - ticks + MODULA) % MODULA;
        if (dial < 0) {
            dial = MODULA + dial + 1;
        }
        tries.add(dial);
    }

    public boolean open() {
        if (tries.size() < 3) {
            System.out.println("Please input 3 combos, now only " + tries.size());
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int attempt = tries.get(i);
            if (attempt != secrets[i]) {
                System.out.println("Wrong Combination!");
                tries.clear();
                return false;
            }
        }
        System.out.println("Lock opened!");
        tries.clear();
        return true;
    }
}
