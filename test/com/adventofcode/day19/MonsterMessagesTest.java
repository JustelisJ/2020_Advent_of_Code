package com.adventofcode.day19;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonsterMessagesTest {

    @Test
    void countMathing0thRule_WithOneRule() {
        List<Rule> rules = List.of(
                new Rule(4, "\"a\"")
        );

        List<String> messages = List.of(
                " ",
                "a",
                "aa",
                "b",
                "ab"
        );

        assertEquals(1, MonsterMessages.countMathing0thRule(rules, messages));
    }
}