package com.adventofcode.day7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("day7.txt")) {
            Pattern pattern = Pattern.compile("(?<amount>\\d+) (?<color>.*?) bags?");
            Map<String, BagRule> bagRules = toStringStream(input).map(line -> {
                String[] lineSplit = line.split(" bags contain ");
                Set<Bag> innerContent = Arrays.stream(lineSplit[1].split(", ")).map(bag -> {
                    Matcher matcher = pattern.matcher(bag);
                    if (matcher.find())
                        return new Bag(matcher.group("color"), Integer.parseInt(matcher.group("amount")));
                    else
                        return Bag.emptyBag;
                }).collect(Collectors.toSet());
                innerContent.forEach(bag -> {
                    if (bag == Bag.emptyBag)
                        innerContent.remove(bag);
                });
                return new BagRule(lineSplit[0], innerContent);
            }).collect(Collectors.toMap(BagRule::getBag, identity()));
            System.out.println(BagRule.howManyBagCanContainShinyGoldBags(bagRules));
            System.out.println(BagRule.bagsInsideShinyGold(bagRules, bagRules.get(BagRule.SHINY_GOLD)) - 1);
        }
    }

    public static Stream<String> toStringStream(InputStream batch) {
        return new Scanner(batch)
                .useDelimiter(".\n")
                .tokens();
    }

}
