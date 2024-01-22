package edu.uchicago.gerber._04interfaces.P9_6;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Appointment[] appointments = {
                new Onetime("Dentist visit", 2023, 10, 20),
                new Daily("Evening walk", 2023, 9, 10),
                new Monthly("Pay rent", 2023, 5, 20)
        };
        int[] date = new int[3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        date[0] = scanner.nextInt();
        System.out.print("Enter month: ");
        date[1] = scanner.nextInt();
        System.out.print("Enter day: ");
        date[2] = scanner.nextInt();

        for (Appointment appointment : appointments) {
            if (appointment.occursOn(date[0], date[1], date[2])) {
                System.out.println(appointment.getDescription());
            }
        }
    }
}
