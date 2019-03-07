package com.company;

public class Main {

    public static void main(String[] args) {

        String[][] array = {
                {"5", "-6", "7", "3"},
                {"0", "1", "2", "2"},
                {"2", "5", "7", "2"},
                {"-5", "9", "g", "-1"}
        };

        try {
            int sum = checkArraySizeAndSumArrayElements(array);
            System.out.println("Сумма всех элементов = " + sum);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            exception.printStackTrace();
        }
    }


    private static int checkArraySizeAndSumArrayElements(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if(array.length != 4) {
            throw new MyArraySizeException("В передаваемом массиве строк больше, чем 4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("В передаваемом массиве столбцов больше, чем 4");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int elem = Integer.parseInt(array[i][j]);
                    sum = sum + elem;
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Не удалось преобразовать в число элемент, находящийся в " +
                            (i + 1) + " строке, в " + (j + 1) + " столбце");
                }
            }
        }
        return sum;
    }

}
