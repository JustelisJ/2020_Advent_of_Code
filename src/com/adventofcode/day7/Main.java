package com.adventofcode.day7;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("day7.txt")) {
            Pattern pattern = Pattern.compile("(?<amount>\\d) (?<color>.*) bags?");
            Map<Bag, BagRule> rules = toStringStream(input).map(line -> {
                String[] split = line.split(" bags contain ");
                String[] bags = split[1].split(", ");
                Set<Bag> insideColors = new HashSet<>();
                for (String inside:bags) {
                    Matcher matcher = pattern.matcher(inside);
                    if(matcher.matches()){
                        insideColors.add(new Bag(matcher.group("color"),
                                Integer.parseInt(matcher.group("amount"))));
                    }
                }
                return new BagRule(new Bag(split[0], 0), insideColors);
            }).collect(Collectors.toMap(BagRule::getBag, Function.identity()));

            System.out.println(rules.values().stream().filter(bagRule -> canContainDeep(rules, bagRule)).count());
        }
    }

    private static int countInnerBagsDeep(Map<Bag, BagRule> rulesByColor, BagRule bagRule) {
        int sum = 0;
        for (Bag innerBag : bagRule.getContains()) {
            sum += innerBag.getAmount();
            sum += innerBag.getAmount() * countInnerBagsDeep(rulesByColor, rulesByColor.get(innerBag));
        }
        return sum;
    }

    private static boolean canContainDeep(Map<Bag, BagRule> bagsByColor, BagRule bagRule) {
        if (bagRule.canContain(Bag.SHINY_GOLD)) {
            return true;
        }

        for (Bag innerBagColor : bagRule.getContains()) {
            BagRule innerBagRule = bagsByColor.get(innerBagColor);
            if (canContainDeep(bagsByColor, innerBagRule)) {
                return true;
            }
        }

        return false;
    }


    public static Stream<String> toStringStream(InputStream batch) {
        return new Scanner(batch)
                .useDelimiter(".\n")
                .tokens();
    }

}
