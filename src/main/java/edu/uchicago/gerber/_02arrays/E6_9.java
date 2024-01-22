package edu.uchicago.gerber._02arrays;

public class E6_9 {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6};
        int[] b = {1, 2, 6, 6};
        System.out.println(equals(a, b));
    }
    public static boolean equals(int[] a, int[] b) {
        if(a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
