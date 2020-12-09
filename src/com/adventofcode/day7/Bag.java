package com.adventofcode.day7;

public class Bag {

    public static Bag emptyBag = new Bag("", 0);

    public String color;
    public int amount;

    public Bag(String color, int amount) {
        this.color = color;
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }
}
