package com.adventofcode.day14;

import com.adventofcode.day13.ShuttleSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(new File("src/resource", "day14.txt"))){
            String bitMask = scanner.nextLine();
            bitMask = bitMask.split(" = ")[1];
            List<Memory> memoryUpload = new ArrayList<>();
            Pattern pattern = Pattern.compile("mem\\[(?<memory>\\d+)\\] = (?<value>\\d+)");
            DockingData dockingData = new DockingData();
            while(scanner.hasNext()){
                String memoryOperation = scanner.nextLine();
                Matcher matcher = pattern.matcher(memoryOperation);
                if(matcher.find()){
                    memoryUpload.add(new Memory(Integer.parseInt(matcher.group("memory")),
                            Integer.parseInt(matcher.group("value"))));
                } else {
                    dockingData.addAllMemoryValues(bitMask, memoryUpload);
                    bitMask = memoryOperation.split(" = ")[1];
                }
            }
            dockingData.addAllMemoryValues(bitMask, memoryUpload);
            System.out.println(dockingData.getSum());
            //too high
            //646639989440645

            //too low
            //56222557828
            //3733287255695
        }
    }

}
