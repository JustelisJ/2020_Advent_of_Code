package com.adventofcode.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String consoleLine = "";
        List<String> passwords = new ArrayList<>();
        do {
            consoleLine = in.nextLine();
            if (!consoleLine.isBlank()){
                passwords.add(consoleLine);
            }
        }while(!consoleLine.isBlank());

        ValidPasswordSearch passwordSearch = new ValidPasswordSearch();
        System.out.println(passwordSearch.passwordValidation(passwords));
        System.out.println(passwordSearch.passwordValidationWithPosition(passwords));
    }
}
