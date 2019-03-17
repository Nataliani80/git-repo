package com.company;

public class Main {
    private static final int SIZE = 10000000;
    private static float[] array = new float[SIZE];

    public static void main(String[] args) {
        MethodFirst.calculateMethodEndTime(array);
        MethodSecond.splitArrayAndCalculateMethodEndTime(array);


    }

}
