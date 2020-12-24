package com.adventofcode.day24;

import java.util.LinkedList;
import java.util.List;

public class Intruction {

    List<String> instructions;

    public Intruction(String instructionLine) {
        this.instructions = new LinkedList<>();
        for (int i = 0; i < instructionLine.length(); i++) {
            if ((instructionLine.charAt(i) == 's') || (instructionLine.charAt(i) == 'n')) {
                instructions.add(instructionLine.substring(i, i + 2));
                i++;
            } else {
                instructions.add(instructionLine.substring(i, i + 1));
            }
        }
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
}
