package com.adventofcode.day10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/resource", "day10.txt"));
        Set<Integer> numbers = new TreeSet<>();
        while (scanner.hasNext()) {
            numbers.add(Integer.valueOf(scanner.next()));
        }
        System.out.println(AdapterArray.find1DifferenceAnd3DifferenceMultiplication(numbers));
    }


}
