package com.adventofcode.day9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EncodingError {

    public static Long twoNumberSumSearch(List<Long> list) {
        Queue<Long> preamble = new ArrayDeque<>();
        for (int i = 0; i < Main.PREAMPLE; i++) {
            preamble.add(list.get(i));
        }
        int position = Main.PREAMPLE;
        for (int i = position; i < list.size(); i++) {
            boolean valid = false;
            Long check = list.get(i);
            Long[] array = preamble.toArray(new Long[preamble.size()]);
            for (int j = 0; j < Main.PREAMPLE; j++) {
                if (preamble.contains(check - array[j])) {
                    valid = true;
                    j = Main.PREAMPLE;
                }
            }
            if (!valid) {
                return check;
            }
            preamble.remove();
            preamble.add(check);
        }
        return -1L;
    }

    public static Long addSmallestAndLargestNumberFromSetThatAddsUpToInvalidNumber(List<Long> list, Long invalidNumber) {
        for (int i = 0; i < list.size(); i++) {
            List<Long> additionList = new ArrayList<>();
            long sum = 0;
            int j = i;
            while (sum < invalidNumber) {
                additionList.add(list.get(j));
                sum += list.get(j);
                j++;
            }
            if (sum == invalidNumber) {
                long min = additionList.get(0);
                long max = additionList.get(0);
                for (int l = 1; l < additionList.size(); l++) {
                    if (min > additionList.get(l))
                        min = additionList.get(l);
                    if (max < additionList.get(l))
                        max = additionList.get(l);
                }
                return min + max;
            }
        }
        return -1L;
    }

}
