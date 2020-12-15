package com.adventofcode.day15;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File("src/resource", "day15.txt"))) {
            String inputLine = scanner.nextLine();
            String[] splitInput = inputLine.split(",");
            List<Integer> inputList = new ArrayList<>();
            for (String number : splitInput) {
                inputList.add(Integer.valueOf(number));
            }

            System.out.println(RambunctiousRecitation.find2020thNumber(inputList));
            System.out.println(RambunctiousRecitation.find30000000thNumber(inputList));
        }
    }

}
