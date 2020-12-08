package com.adventofcode.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean endOfInput = false;
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<String> customsForms = new ArrayList<>();
        String customsForm = "";

        do {
            consoleLine = in.nextLine();
            if(consoleLine.isBlank() && endOfInput)
                break;
            if(!consoleLine.isBlank()) {
                customsForm = customsForm + " " + consoleLine;
                endOfInput = false;
            } else {
                customsForms.add(customsForm);
                customsForm = "";
                endOfInput = true;
            }
        }while(true);

        CustomCustoms customs = new CustomCustoms();
        System.out.println("Questions answered yes: " + customs.findAnsweredYes(customsForms));
        System.out.println("answer: " + customs.findAnswersThatRepeat(customsForms));
    }
}
