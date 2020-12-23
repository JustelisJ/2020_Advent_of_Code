package com.adventofcode.day19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonsterMessages {

    static int countMathing0thRule(List<Rule> rules, List<String> messages) {
        int count = 0;

        Set<String> combinations = allPossibleRuleCombinations(rules);
        for (String message : messages) {
            if (combinations.contains(message)) {
                count++;
            }
        }

        return count;
    }

    private static Set<String> allPossibleRuleCombinations(List<Rule> rules) {
        Set<String> combinations = new HashSet<>();

        for (Rule rule : rules) {

        }

        return combinations;
    }

}
