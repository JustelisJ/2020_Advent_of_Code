package com.adventofcode.day12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(new File("src/resource", "day12.txt"));){
            List<NavigationInstruction> instructions = new ArrayList<>();
            while (scanner.hasNext()) {
                String instruction = scanner.next();
                instructions.add(new NavigationInstruction(instruction.charAt(0),
                        Integer.parseInt(instruction.substring(1))));
            }
            System.out.println("First star answer: " + RainRisk.XandYCoordinateSum(instructions));
            System.out.println("Second star answer: " + RainRisk.XandYCoordinateSumWithWaypoint(instructions));
        }
    }

}
