package com.adventofcode.day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cupOrder = "";
        try (Scanner scanner = new Scanner(new File("src/resource", "day23.txt"))) {
            cupOrder = scanner.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> cupList = new LinkedList<>();
        for (char cupNumber : cupOrder.toCharArray()) {
            cupList.add(Integer.valueOf(String.valueOf(cupNumber)));
        }

        System.out.println(CrabCups.moveCups(cupList));
    }

}
