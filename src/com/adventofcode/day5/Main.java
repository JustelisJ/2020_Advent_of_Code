package com.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean endOfInput = false;
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<String> boardingPasses = new ArrayList<>();
        do {
            consoleLine = in.nextLine();
            if(!consoleLine.isBlank()){
                boardingPasses.add(consoleLine);
            }
        }while(!consoleLine.isBlank());

        BinaryBoarding binaryBoarding = new BinaryBoarding();
        System.out.println("Highest ID: " + binaryBoarding.findHighestID(boardingPasses));
        System.out.println("Empty seat ID: " + binaryBoarding.findEmptySeat(boardingPasses));
    }
}
