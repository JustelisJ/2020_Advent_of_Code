package com.adventofcode.day16;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicketTranslation {

    public static int findInvalidTicketErrorRate(List<String> rules, List<List<Integer>> nearbyTickets) {
        Set<Integer> validNumbers = getValidNumbersFromRules(rules);
        int errorRate = 0;

        for (List<Integer> nearbyTicket : nearbyTickets) {
            for (Integer number : nearbyTicket) {
                if (!validNumbers.contains(number)) {
                    errorRate += number;
                }
            }
        }

        return errorRate;
    }

    private static Set<Integer> getValidNumbersFromRules(List<String> rules) {
        Set<Integer> validNumbers = new HashSet<>();
        Pattern pattern = Pattern.compile("(?<leftNumber>\\d+)-(?<rightNumber>\\d+)");
        for (String rule : rules) {
            int from = 0;
            int to = 0;
            String[] splitRule = rule.split(" ");
            Matcher matcher1 = pattern.matcher(splitRule[1]);
            Matcher matcher2 = pattern.matcher(splitRule[3]);
            if (matcher1.matches()) {
                from = Integer.parseInt(matcher1.group("leftNumber"));
                to = Integer.parseInt(matcher1.group("rightNumber"));
            }
            for (int i = from; i <= to; i++) {
                validNumbers.add(i);
            }
            if (matcher2.matches()) {
                from = Integer.parseInt(matcher2.group("leftNumber"));
                to = Integer.parseInt(matcher2.group("rightNumber"));
            }
            for (int i = from; i <= to; i++) {
                validNumbers.add(i);
            }
        }
        return validNumbers;
    }

}
