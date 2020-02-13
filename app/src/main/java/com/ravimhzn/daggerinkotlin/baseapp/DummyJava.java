package com.ravimhzn.daggerinkotlin.baseapp;

public class DummyJava {
    public DummyJava(int x, int y) {
        String bitNum1 = Integer.toBinaryString(x);
        String bitNum2 = Integer.toBinaryString(y);
        char a[] = bitNum1.toCharArray();
        char b[] = bitNum1.toCharArray();

        for (char i : a) {
            System.out.println("i\t");
        }
    }

    DummyJava(){
        for (int i = 0; i <= 1; i++) {
            for(int j=0; j<=2; j++){

            }
        }
    }

    public static void main(String args[]) {
        new DummyJava();
    }


    private boolean fun(String value) {
        char charArr[] = value.toCharArray();

        for (int i = 0; i <= 1; i++) {
            for(int j=0; j<=1; j++){
                System.out.println("[" + i + ", " + j + "]");
            }

        }
        return false;
    }
}
