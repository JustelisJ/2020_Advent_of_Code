package com.adventofcode.day19;

public class Rule {

    int ruleNumber;
    String rule;

    public Rule(int ruleNumber, String rule) {
        this.ruleNumber = ruleNumber;
        this.rule = rule;
    }

    public int getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(int ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
