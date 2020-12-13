package com.adventofcode.day13;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(new File("src/resource", "day13.txt"))){
            int estimateArrival = Integer.parseInt(scanner.next());
            String busses = scanner.next();
            String[] individualBusses = busses.split(",");
            List<Integer> bussesAsIntegers = new ArrayList<>();
            for(String bus : individualBusses){
                if(!bus.equals("x")){
                    bussesAsIntegers.add(Integer.valueOf(bus));
                }
            }
            System.out.println(ShuttleSearch.earliestBusIDMultipliedByWaitingMinutes(estimateArrival, bussesAsIntegers));
        }
    }

}
