package com.adventofcode.day1;

import java.util.List;

public class FindYear2020 {

    public int multiplicationOf2YearsWhoseSumIs2020(List<Integer> years) {
        for (int i = 0; i < years.size() - 1; i++) {
            for (int j = i + 1; j < years.size(); j++) {
                if (years.get(i) + years.get(j) == 2020) {
                    System.out.println(String.format("%d + %d =", years.get(i), years.get(j)));
                    return years.get(i) * years.get(j);
                }
            }
        }

        return 0;
    }

    public int multiplicationOf3YearsWhoseSumIs2020(List<Integer> years) {
        for (int i = 0; i < years.size() - 2; i++) {
            for (int j = i; j < years.size() - 1; j++) {
                for (int h = j; h < years.size(); h++) {
                    if (years.get(i) + years.get(j) + years.get(h) == 2020) {
                        System.out.println(String.format("%d + %d + %d =", years.get(i), years.get(j), years.get(h)));
                        return years.get(i) * years.get(j) * years.get(h);
                    }
                }
            }
        }

        return 0;
    }

}
