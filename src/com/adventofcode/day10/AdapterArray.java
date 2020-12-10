package com.adventofcode.day10;

import java.util.Set;

public class AdapterArray {

    public static int find1DifferenceAnd3DifferenceMultiplication(Set<Integer> numbers) {
        int difference1 = 0;
        int difference3 = 0;
        int initialJolt = 0;

        for (Integer number : numbers) {
            if ((1 <= (number - initialJolt)) && (3 >= (number - initialJolt))) {
                if (number - initialJolt == 1)
                    difference1++;
                if (number - initialJolt == 3)
                    difference3++;
                initialJolt = number;

            }
        }
        difference3++;

        return difference1 * difference3;
    }

}
