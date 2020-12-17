package com.adventofcode.day15;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RambunctiousRecitationTest {

    @Test
    void find2020thNumber() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/resource", "day15.txt"))) {
            String inputLine = scanner.nextLine();
            String[] splitInput = inputLine.split(",");
            List<Integer> inputList = new ArrayList<>();
            for (String number : splitInput) {
                inputList.add(Integer.valueOf(number));
            }

            System.out.println(RambunctiousRecitation.find2020thNumber(inputList));
        }
    }

    @Test
    void find30000000thNumber() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/resource", "day15.txt"))) {
            String inputLine = scanner.nextLine();
            String[] splitInput = inputLine.split(",");
            List<Integer> inputList = new ArrayList<>();
            for (String number : splitInput) {
                inputList.add(Integer.valueOf(number));
            }

            System.out.println(RambunctiousRecitation.find30000000thNumber(inputList));
        }
    }
}