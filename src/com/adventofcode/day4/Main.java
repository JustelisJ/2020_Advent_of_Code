package com.adventofcode.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean endOfInput = false;
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<String> passports = new ArrayList<>();
        String passport = "";
        do {
            consoleLine = in.nextLine();
//
            if (consoleLine.isBlank() && endOfInput)
                break;

            if (!consoleLine.isBlank()) {
                passport = passport + " " + consoleLine;
                endOfInput = false;
            } else {
                passports.add(passport);
                passport = "";
                endOfInput = true;
            }

        } while (true);

        PassportProcessing passportProcessing = new PassportProcessing();
        System.out.println("Valid passports: " + passportProcessing.validatePasswords(passports));
    }
}
