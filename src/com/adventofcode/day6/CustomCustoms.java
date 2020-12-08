package com.adventofcode.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomCustoms {

    public int findAnsweredYes(List<String> customs) {
        int answer = 0;
        Set<Character> differentChars = new HashSet<>();

        for (int i = 0; i < customs.size(); i++) {
            for (char symbol : customs.get(i).toCharArray()) {
                differentChars.add(symbol);
            }
            answer += differentChars.size();
            differentChars = new HashSet<>();
        }

        return answer;
    }

    public int findAnswersThatRepeat(List<String> customsGroups) {
        int answer = 0;
        Set<Character> differentChars = new HashSet<>();

        for (int i = 0; i < customsGroups.size(); i++) {
            String[] individual = customsGroups.get(i).split(" ");
            for (char symbol : individual[1].toCharArray()) {
                differentChars.add(symbol);
            }
            for (int j = 2; j < individual.length; j++) {
                int finalJ = j;
                differentChars.removeIf(question -> (!individual[finalJ].contains(String.valueOf(question))));
            }
            answer += differentChars.size();
            differentChars = new HashSet<>();
        }

        return answer;
    }

}
