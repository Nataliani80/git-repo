package com.company;

import java.util.Arrays;

class MethodSecond {

    static void splitArrayAndCalculateMethodEndTime(float[] array) {
        int half = array.length / 2;
        Arrays.fill(array, 1);
        float[] array1 = new float[half];
        float[] array2 = new float[half];

        long startTime = System.currentTimeMillis();
        System.arraycopy(array, 0, array1, 0, half);
        System.arraycopy(array, half, array2, 0, half);

        Thread t1 = new Thread(new RunnableClass(array1));
        t1.start();

        Thread t2 = new Thread(new RunnableClass(array2));
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, array, 0, half);
        System.arraycopy(array2, 0, array, half, half);
        System.out.println("Время работы второго метода: " + (System.currentTimeMillis() - startTime) + " ms");
    }


}
