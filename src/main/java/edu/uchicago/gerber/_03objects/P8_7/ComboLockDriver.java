package edu.uchicago.gerber._03objects.P8_7;

public class ComboLockDriver {
    public static void main(String[] args){
        ComboLock comboLock = new ComboLock(1,39,3);
        comboLock.turnRight(1);
        comboLock.turnLeft(2);
        comboLock.turnRight(4);
        System.out.println(comboLock.open());
    }
}
