package com.adventofcode.day23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CrabCups {

    public static String moveCups(List<Integer> cupListOriginal, int times) {
        LinkedList<Integer> cupList = new LinkedList<>(cupListOriginal);
        int highestValue = cupList.stream().max(Comparator.naturalOrder()).get();
        int zeroIndex = 0;

        for (int i = 0; i < times; i++) {
            int currentCupNumber = cupList.remove(zeroIndex);
            int destinationIndex = 0;
            List<Integer> next3Cups = getNextThreeCups(cupList, zeroIndex);

            int j = 1;
            int currectCupNumberCheck = currentCupNumber;
            while (j != 0) {
                if (currectCupNumberCheck - j <= 0) {
                    currectCupNumberCheck = highestValue + 1;
                    j = 1;
                }
                if (!next3Cups.contains((currectCupNumberCheck - j))) {
                    destinationIndex = cupList.indexOf((currectCupNumberCheck - j)) + 1;
                    j = 0;
                } else {
                    j++;
                }
            }
            if (i % 1000 == 0) {
                System.out.printf("%dth cycle%n", i);
            }

            cupList.addAll(destinationIndex, next3Cups);
            cupList.add(currentCupNumber);
        }

        String cupListAsString = cupList.toString().replace(", ", "");
        cupListAsString = cupListAsString.substring(1, cupListAsString.length() - 1);
        return String.format("%s%s", cupListAsString.substring(cupListAsString.indexOf("1") + 1),
                cupListAsString.substring(0, cupListAsString.indexOf("1")));
    }

    private static List<Integer> getNextThreeCups(List<Integer> cupList, int currentCupIndex) {
        List<Integer> nextThreeCups = new ArrayList<>();
        nextThreeCups.add(cupList.remove(currentCupIndex));
        nextThreeCups.add(cupList.remove(currentCupIndex));
        nextThreeCups.add(cupList.remove(currentCupIndex));
        return nextThreeCups;
    }

    public static List<Integer> inflateListToMillion(List<Integer> cupList) {
        for (int i = cupList.size(); i < 1000000; i++) {
            cupList.add(i);
        }

        return cupList;
    }

}
