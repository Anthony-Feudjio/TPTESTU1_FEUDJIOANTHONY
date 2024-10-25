package com.stjean.operation;

import java.util.Arrays;

public class OperationMathematique {

    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public int factorial(int number) throws IllegalParamISIException {
        if (number == 0) {
            return 1;
        }
        if (number < 0) {
            throw new IllegalParamISIException("Factorial of negative numbers is not defined");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public class Sorter {

        public static int[] sort(int[] lists) {
            Arrays.sort(lists);
            int[] sortedList = new int[lists.length];
            for (int i = 0; i < lists.length; i++) {
                sortedList[i] = lists[lists.length - 1 - i];
            }
            return sortedList;
        }
    }

}
