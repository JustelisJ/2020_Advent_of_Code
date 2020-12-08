package com.adventofcode.day3;

import com.adventofcode.day6.CustomCustoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean endOfInput = false;
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<String> map = new ArrayList<>();
        do {
            consoleLine = in.nextLine();
            if (!consoleLine.isBlank()){
                map.add(consoleLine);
            }
        }while(!consoleLine.isBlank());
        CountTreesInPath countTreesInPath = new CountTreesInPath();
        long slope_1 = countTreesInPath.countTreeOnPath(map, 1, 1);
        System.out.println("Slope 1: " + slope_1);
        long slope_2 = countTreesInPath.countTreeOnPath(map, 3, 1);
        System.out.println("Slope 2: " + slope_2);
        long slope_3 = countTreesInPath.countTreeOnPath(map, 5, 1);
        System.out.println("Slope 3: " + slope_3);
        long slope_4 = countTreesInPath.countTreeOnPath(map, 7, 1);
        System.out.println("Slope 4: " + slope_4);
        long slope_5 = countTreesInPath.countTreeOnPath(map, 1, 2);
        System.out.println("Slope 5: " + slope_5);
        long slopeMultiplication = slope_1 * slope_2 * slope_3 * slope_4 * slope_5;
        System.out.println("All slope multiplication: " + slopeMultiplication);
    }
}
