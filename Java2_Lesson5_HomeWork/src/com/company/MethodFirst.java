package com.company;

import java.util.Arrays;

class MethodFirst {
    static void calculateMethodEndTime(float[] array) {
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
