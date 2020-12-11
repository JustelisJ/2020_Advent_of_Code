package com.adventofcode.day11;

import com.adventofcode.day10.AdapterArray;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/resource", "day11"));
        List<String> map = new ArrayList<>();
        while (scanner.hasNext()) {
            map.add(scanner.next());
        }
        System.out.println(SeatingSystem.countUnoccupiedSeats(map));
        System.out.println(SeatingSystem.countUnoccupiedSeatsV2(map));
    }

}
