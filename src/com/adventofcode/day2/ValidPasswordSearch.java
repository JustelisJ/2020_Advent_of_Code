package com.adventofcode.day2;

import java.util.List;

public class ValidPasswordSearch {

    public int passwordValidation(List<String> passwords){
        int correctPasswords = 0;

        for(String passwordLine : passwords){
            String[] splitPasswordLine = passwordLine.split(" ");
            String[] min_max = splitPasswordLine[0].split("-");
            int min = Integer.parseInt(min_max[0]);
            int max = Integer.parseInt(min_max[1]);
            char letter = splitPasswordLine[1].charAt(0);
            String password = splitPasswordLine[2];

            int letterCount = 0;
            for(char c : password.toCharArray()){
                if (c == letter){
                    letterCount++;
                }
            }

            if((min <= letterCount) && (max >= letterCount)){
                correctPasswords++;
            }
        }

        return correctPasswords;
    }

    public int passwordValidationWithPosition(List<String> passwords){
        int correctPasswords = 0;

        for(String passwordLine : passwords){
            String[] splitPasswordLine = passwordLine.split(" ");
            String[] min_max = splitPasswordLine[0].split("-");
            int min = Integer.parseInt(min_max[0]);
            int max = Integer.parseInt(min_max[1]);
            char letter = splitPasswordLine[1].charAt(0);
            String password = splitPasswordLine[2];

            char[] passwordAsCharArray = password.toCharArray();
            if (passwordAsCharArray[min - 1] == letter ^ passwordAsCharArray[max - 1] == letter){
                correctPasswords++;
            }
        }

        return correctPasswords;
    }

}
