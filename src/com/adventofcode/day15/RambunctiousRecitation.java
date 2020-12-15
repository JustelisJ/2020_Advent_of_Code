package com.adventofcode.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RambunctiousRecitation {

    public static int find2020thNumber(List<Integer> integerList) {
        List<Integer> integerListCopy = new ArrayList<>(integerList);
        for (int i = integerListCopy.size(); i < 2020; i++) {
            int previousNumber = integerListCopy.get(i - 1);
            if (integerListCopy.stream().filter(number -> number == previousNumber).count() == 1) {
                integerListCopy.add(0);
            } else {
                for (int j = integerListCopy.size() - 2; j >= 0; j--) {
                    if (integerListCopy.get(j) == previousNumber) {
                        integerListCopy.add(i - (j + 1));
                        j = -1;
                    }
                }
            }
        }

        return integerListCopy.get(2019);
    }

    public static int find30000000thNumber(List<Integer> integerList) {
        Map<Integer, Integer> numberLastLocationMap = new HashMap<>();
        for (int i = 0; i < integerList.size(); i++) {
            numberLastLocationMap.put(integerList.get(i), i + 1);
        }
        for (int i = integerList.size(); i < 30000000; i++) {
            int previousNumber = integerList.get(i - 1);
            if (numberLastLocationMap.containsKey(previousNumber)) {
                int subtraction = (i) - numberLastLocationMap.get(previousNumber);
                integerList.add(subtraction);
                numberLastLocationMap.put(previousNumber, i);
                if (!numberLastLocationMap.containsKey(subtraction)) {
                    numberLastLocationMap.put(subtraction, i + 1);
                }
            } else {
                integerList.add(0);
                numberLastLocationMap.put(0, i);
            }
        }

        return integerList.get(30000000 - 1);
    }

}
