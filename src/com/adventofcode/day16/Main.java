package com.adventofcode.day16;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int blankLineCount = 0;
        List<String> rules = new ArrayList<>();
        List<Integer> myTicket = new ArrayList<>();
        List<List<Integer>> nearbyTickets = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/resource", "day16.txt"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (line.isBlank()) {
                    blankLineCount++;
                } else {
                    if (blankLineCount == 0) {
                        rules.add(line);
                    }
                    if (blankLineCount == 1) {
                        if (!line.equals("your ticket:")) {
                            String[] splitMyTicket = line.split(",");
                            for (String number : splitMyTicket) {
                                myTicket.add(Integer.valueOf(number));
                            }
                        }
                    }
                    if (blankLineCount == 2) {
                        if (!line.equals("nearby tickets:")) {
                            String[] splitNearbyTicket = line.split(",");
                            List<Integer> nearbyTicket = new ArrayList<>();
                            for (String number : splitNearbyTicket) {
                                nearbyTicket.add(Integer.valueOf(number));
                            }
                            nearbyTickets.add(nearbyTicket);
                        }
                    }
                }
            }

            System.out.println(TicketTranslation.findInvalidTicketErrorRate(rules, nearbyTickets));
        }
    }

}
