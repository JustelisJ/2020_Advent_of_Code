package com.adventofcode.day4;

import java.util.List;

public class PassportProcessing {

    public int validatePasswords(List<String> passports){
        int validPassports = 0;

        int byr = -1;
        int iyr = -1;
        int eyr = -1;
        String hgt = "";
        String hcl = "";
        String ecl = "";
        String pid = "";
        String cid = "";

        for (String passport : passports){
            String[] splitPassport = passport.split(" ");
            for(String value : splitPassport){
                if(!value.isBlank()){
                    String prefix = value.substring(0, 3);
                    switch (prefix) {
                        case "byr":
                            byr = Integer.parseInt(value.split(":")[1]);
                            break;
                        case "iyr":
                            iyr = Integer.parseInt(value.split(":")[1]);
                            break;
                        case "eyr":
                            eyr = Integer.parseInt(value.split(":")[1]);
                            break;
                        case "hgt":
                            hgt = value.split(":")[1];
                            break;
                        case "hcl":
                            hcl = value.split(":")[1];
                            break;
                        case "ecl":
                            ecl = value.split(":")[1];
                            break;
                        case "pid":
                            pid = value.split(":")[1];
                            break;
                        case "cid":
                            cid = value.split(":")[1];
                            break;
                    }
                }
            }

            if(validateBirthYear(byr) && validateIssueYear(iyr) && validateExpirationYear(eyr) && validateHeight(hgt)
                    && validateHairColor(hcl) && validateEyeColor(ecl) && validatePassportID(pid))
                validPassports++;

            byr = -1;
            iyr = -1;
            eyr = -1;
            hgt = "";
            hcl = "";
            ecl = "";
            pid = "";
            cid = "";
        }

        return validPassports;
    }

    private boolean validatePassportID(String pid) {
        return pid.matches("[0-9]{9}");
    }

    private boolean validateEyeColor(String ecl) {
        return ecl.equals("amb") || ecl.equals("blu") ||
                ecl.equals("brn") ||
                ecl.equals("gry") ||
                ecl.equals("grn") ||
                ecl.equals("hzl") ||
                ecl.equals("oth");
    }

    private boolean validateHairColor(String hcl) {
        if(hcl.length() != 7)
            return false;
        if(hcl.charAt(0) != '#')
            return false;
        for(int i = 1; i < hcl.length(); i++){
            if((hcl.charAt(i) >= 0 && hcl.charAt(i) <= 47) || (hcl.charAt(i) >= 58 && hcl.charAt(i) <= 96) ||
                    (hcl.charAt(i) >= 103 && hcl.charAt(i) <= 127))
                return false;
        }
        return true;
    }

    private boolean validateHeight(String hgt) {
        if(hgt.isBlank())
            return false;
        Integer height = Integer.parseInt(hgt.substring(0, hgt.length()-2));
        String measurment = hgt.substring(hgt.length()-2);
        if(measurment.equals("cm") && (height >= 150 && height <= 193))
            return true;
        if(measurment.equals("in") && (height >= 59 && height <= 76))
            return true;
        return false;
    }

    private boolean validateExpirationYear(int eyr) {
        return eyr >= 2020 && eyr <= 2030;
    }

    private boolean validateIssueYear(int iyr) {
        return iyr >= 2010 && iyr <= 2020;
    }

    private boolean validateBirthYear(int byr) {
        return byr >= 1920 && byr <= 2002;
    }

}
