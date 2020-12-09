package com.adventofcode.day7;

import java.util.Map;
import java.util.Set;

public class BagRule {

    public static final String SHINY_GOLD = "shiny gold";

    String bag;
    Set<Bag> contains;

    public BagRule(String bag, Set<Bag> contains) {
        this.bag = bag;
        this.contains = contains;
    }

    public String getBag() {
        return bag;
    }

    public Set<Bag> getContains() {
        return contains;
    }

    public static int howManyBagCanContainShinyGoldBags(Map<String, BagRule> bagRules) {
        int count = 0;

        for (BagRule bagRule : bagRules.values()) {
            if (containsInside(bagRules, bagRule))
                count++;
        }

        return count;
    }

    private static boolean containsInside(Map<String, BagRule> bagRules, BagRule bagRule) {
        if (bagRuleContains(bagRule)) {
            return true;
        }
        if (!bagRule.contains.isEmpty()) {
            for (Bag innerBag : bagRule.contains) {
                BagRule innerBagRule = bagRules.get(innerBag.color);
                if (containsInside(bagRules, innerBagRule))
                    return true;
            }
        }

        return false;
    }

    private static boolean bagRuleContains(BagRule bagRule) {
        for (Bag bag : bagRule.contains) {
            if (bag.color.equals(SHINY_GOLD))
                return true;
        }

        return false;
    }

    public static int bagsInsideShinyGold(Map<String, BagRule> bagRules, BagRule bagRule) {
        int bagsInside = 1;

        for (Bag bag : bagRule.contains) {
            bagsInside += bag.amount * bagsInsideShinyGold(bagRules, bagRules.get(bag.color));
        }

        return bagsInside;
    }

}
