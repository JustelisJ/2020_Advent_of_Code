package com.adventofcode.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<Integer> years = new ArrayList<>();
        do {
            consoleLine = in.nextLine();
            if(!consoleLine.isBlank()){
                Integer year = Integer.parseInt(consoleLine);
                years.add(year);
            }
        }while(!consoleLine.isBlank());

        FindYear2020 search = new FindYear2020();
        System.out.println(search.multiplicationOf2YearsWhoseSumIs2020(years));
        System.out.println(search.multiplicationOf3YearsWhoseSumIs2020(years));
    }
}
