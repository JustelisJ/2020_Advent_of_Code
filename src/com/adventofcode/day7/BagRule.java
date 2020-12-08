package com.adventofcode.day7;

import java.util.Map;
import java.util.Set;

public class BagRule {

    public static final String SHINY_GOLD = "shiny gold";

    Bag bag;
    Set<Bag> contains;

    public BagRule(Bag bag, Set<Bag> contains) {
        this.bag = bag;
        this.contains = contains;
    }

    public Bag getBag(){
        return bag;
    }

    public Set<Bag> getContains(){
        return contains;
    }

    public boolean canContain(Bag bagColor) {
        return contains.contains(bagColor);
    }

}
