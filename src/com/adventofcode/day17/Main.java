package com.adventofcode.day17;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<List<List<Character>>> xyz = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/resource", "day17.txt"))) {
            List<List<Character>> xy = new ArrayList<>();
            while (scanner.hasNextLine()) {
                List<Character> x = new ArrayList<>();
                for (char c : scanner.nextLine().toCharArray()) {
                    x.add(c);
                }
                xy.add(x);
            }
            xyz.add(xy);
        }

        System.out.println("initial count: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);

        System.out.println("1 cycle: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);

        System.out.println("2 cycle: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);

        System.out.println("3 cycle: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);

        System.out.println("4 cycle: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);

        System.out.println("5 cycle: " + ConwayCubes.countActiveCubes(xyz));
        xyz = ConwayCubes.cycle(xyz);
        
        System.out.println("6 cycle: " + ConwayCubes.countActiveCubes(xyz));
    }

}
