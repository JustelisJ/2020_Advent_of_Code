package com.adventofcode.day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern rulePattern = Pattern.compile("(?<ruleNumber>\\d+): (?<rule>\\w+)");
        List<Rule> rules = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/resource", "day19.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = rulePattern.matcher(line);
                if (matcher.matches()) {
                    rules.add(new Rule(Integer.parseInt(matcher.group("ruleNumber")), matcher.group("rule")));
                } else {
                    messages.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(MonsterMessages.countMathing0thRule(rules, messages));

    }

}
