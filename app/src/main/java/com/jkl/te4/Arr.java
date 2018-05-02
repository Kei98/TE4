package com.jkl.te4;

public class Arr {
    private int largo = (int) (Math.random() * 20 + 20);
    private int arra[] = new int[largo];

    public void createValues() {
        for (int i = 0; i < largo; i++) {
            arra[i] = (int) (Math.random() * 1000);
        }
    }

    public void sort() {
        int n = arra.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arra[j - 1] > arra[j]) {
                    // swap elements
                    temp = arra[j - 1];
                    arra[j - 1] = arra[j];
                    arra[j] = temp;
                }

            }
        }
    }

    public void printL() {
        System.out.print("[");
        for (int i = 0; i < arra.length - 1; i++) {
            System.out.print(arra[i] + ", ");
        }
        System.out.print(arra[arra.length - 1]);
        System.out.print("]");
        System.out.println(" ");
    }
}
