package com.adventofcode.day11;

import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {

    public static int countUnoccupiedSeats(List<String> map) {
        int count = 0;
        boolean changedOccured = true;

        while (changedOccured) {
            changedOccured = false;
            List<String> mapAfterFirstRule = firstRule(map);
            if (map.hashCode() != mapAfterFirstRule.hashCode()) {
                changedOccured = true;
                map = new ArrayList<>(mapAfterFirstRule);
            }

            List<String> mapAfterSecondRule = secondRule(map);
            if (map.hashCode() != mapAfterSecondRule.hashCode()) {
                changedOccured = true;
                map = new ArrayList<>(mapAfterSecondRule);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                if (map.get(i).charAt(j) == '#')
                    count++;
            }
        }

        return count;
    }

    private static List<String> firstRule(List<String> map) {
        List<String> mapCopy = new ArrayList<>(map);

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                try {
                    //Virsutiniam kairiam kampe
                    if ((map.get(i).charAt(j) == 'L') && (i == 0) && (j == 0) && (map.get(i).charAt(j + 1) != '#') &&
                            (map.get(i + 1).charAt(j) != '#') && (map.get(i + 1).charAt(j + 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Virsutiniam desniam kampe
                    else if ((map.get(i).charAt(j) == 'L') && (i == 0) && (j == map.get(i).length() - 1) &&
                            (map.get(i).charAt(j - 1) != '#') && (map.get(i + 1).charAt(j - 1) != '#') &&
                            (map.get(i + 1).charAt(j) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //apatiniam kairiam kampe
                    else if (((map.get(i).charAt(j) == 'L') && (i == map.size() - 1) && (j == 0) &&
                            (map.get(i - 1).charAt(j) != '#') && (map.get(i - 1).charAt(j + 1) != '#') &&
                            (map.get(i).charAt(j + 1) != '#'))) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //apatiniam desniam kampe
                    else if ((map.get(i).charAt(j) == 'L') && (i == map.size() - 1) &&
                            (j == map.get(i).length() - 1) && (map.get(i - 1).charAt(j - 1) != '#') &&
                            (map.get(i - 1).charAt(j) != '#') && (map.get(i).charAt(j - 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Palei kaire siena
                    else if ((map.get(i).charAt(j) == 'L') && (j == 0) && (map.get(i - 1).charAt(j) != '#') &&
                            (map.get(i - 1).charAt(j + 1) != '#') && (map.get(i).charAt(j + 1) != '#') &&
                            (map.get(i + 1).charAt(j) != '#') && (map.get(i + 1).charAt(j + 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Palei desine siena
                    else if ((map.get(i).charAt(j) == 'L') && (j == map.get(i).length() - 1) &&
                            (map.get(i - 1).charAt(j - 1) != '#') && (map.get(i - 1).charAt(j) != '#') &&
                            (map.get(i).charAt(j - 1) != '#') && (map.get(i + 1).charAt(j - 1) != '#') &&
                            (map.get(i + 1).charAt(j) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Palei virsutine koordinate
                    else if ((map.get(i).charAt(j) == 'L') && (i == 0) &&
                            (map.get(i).charAt(j - 1) != '#') && (map.get(i).charAt(j + 1) != '#') &&
                            (map.get(i + 1).charAt(j - 1) != '#') && (map.get(i + 1).charAt(j) != '#') &&
                            (map.get(i + 1).charAt(j + 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Palei apatine siena
                    else if ((map.get(i).charAt(j) == 'L') && (i == map.size() - 1) &&
                            (map.get(i - 1).charAt(j - 1) != '#') && (map.get(i - 1).charAt(j) != '#') &&
                            (map.get(i - 1).charAt(j + 1) != '#') && (map.get(i).charAt(j - 1) != '#') &&
                            (map.get(i).charAt(j + 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }

                    //Viduri zemelapio
                    else if ((map.get(i).charAt(j) == 'L') &&
                            (map.get(i - 1).charAt(j - 1) != '#') && (map.get(i - 1).charAt(j) != '#') &&
                            (map.get(i - 1).charAt(j + 1) != '#') && (map.get(i).charAt(j - 1) != '#') &&
                            (map.get(i).charAt(j + 1) != '#') && (map.get(i + 1).charAt(j - 1) != '#') &&
                            (map.get(i + 1).charAt(j) != '#') && (map.get(i + 1).charAt(j + 1) != '#')) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }
                } catch (Exception e) {

                }
            }
        }

        return mapCopy;
    }

    private static List<String> secondRule(List<String> map) {
        List<String> mapCopy = new ArrayList<>(map);

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                int occupiedSeatCount = 0;

                try {
                    if (map.get(i - 1).charAt(j - 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i - 1).charAt(j) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i - 1).charAt(j + 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i).charAt(j - 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i).charAt(j + 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i + 1).charAt(j - 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i + 1).charAt(j) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }
                try {
                    if (map.get(i + 1).charAt(j + 1) == '#')
                        occupiedSeatCount++;
                } catch (Exception e) {
                }

                if (map.get(i).charAt(j) == '#') {
                    if (occupiedSeatCount >= 4) {
                        char[] line = mapCopy.get(i).toCharArray();
                        line[j] = 'L';
                        mapCopy.set(i, String.copyValueOf(line));
                    }
                }
            }
        }

        return mapCopy;
    }

    public static int countUnoccupiedSeatsV2(List<String> map) {
        int count = 0;
        boolean changedOccured = true;

        while (changedOccured) {
            changedOccured = false;
            List<String> mapAfterFirstRule = firstRuleV2(map);
            if (map.hashCode() != mapAfterFirstRule.hashCode()) {
                changedOccured = true;
                map = new ArrayList<>(mapAfterFirstRule);
            }

            List<String> mapAfterSecondRule = secondRuleV2(map);
            if (map.hashCode() != mapAfterSecondRule.hashCode()) {
                changedOccured = true;
                map = new ArrayList<>(mapAfterSecondRule);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                if (map.get(i).charAt(j) == '#')
                    count++;
            }
        }

        return count;
    }

    private static List<String> firstRuleV2(List<String> map) {
        List<String> mapCopy = new ArrayList<>(map);

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                boolean occupiedSeatInSight = false;
                //check up
                if(map.get(i).charAt(j) == 'L'){
                    if (!occupiedSeatInSight) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map.get(k).charAt(j) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(k).charAt(j) == 'L')
                                k = 0;
                        }
                    }

                    //check down
                    if (!occupiedSeatInSight) {
                        for (int k = i + 1; k < map.size(); k++) {
                            if (map.get(k).charAt(j) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(k).charAt(j) == 'L')
                                k = map.size();
                        }
                    }

                    //check left
                    if (!occupiedSeatInSight) {
                        for (int k = j - 1; k >= 0; k--) {
                            if (map.get(i).charAt(k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i).charAt(k) == 'L')
                                k = 0;
                        }
                    }

                    //check right
                    if (!occupiedSeatInSight) {
                        for (int k = j + 1; k < map.get(i).length(); k++) {
                            if (map.get(i).charAt(k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i).charAt(k) == 'L')
                                k = map.get(i).length();
                        }
                    }

                    //check diagonal up-left
                    if (!occupiedSeatInSight) {
                        for (int k = 1; (i - k >= 0) && (j - k >= 0); k++) {
                            if (map.get(i - k).charAt(j - k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i - k).charAt(j - k) == 'L')
                                k = map.get(i).length();
                        }
                    }

                    //check diagonal up-right
                    if (!occupiedSeatInSight) {
                        for (int k = 1; (i - k >= 0) && (j + k < map.get(i - k).length()); k++) {
                            if (map.get(i - k).charAt(j + k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i - k).charAt(j + k) == 'L')
                                k = map.get(i).length();
                        }
                    }

                    //check diagonal down-left
                    if (!occupiedSeatInSight) {
                        for (int k = 1; (i + k < map.size()) && (j - k >= 0); k++) {
                            if (map.get(i + k).charAt(j - k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i + k).charAt(j - k) == 'L')
                                k = map.get(i).length();
                        }
                    }

                    //check diagonal down-right
                    if (!occupiedSeatInSight) {
                        for (int k = 1; (i + k < map.size()) && (j + k < map.get(i + k).length()); k++) {
                            if (map.get(i + k).charAt(j + k) == '#')
                                occupiedSeatInSight = true;
                            if (map.get(i + k).charAt(j + k) == 'L')
                                k = map.get(i).length();
                        }
                    }


                    if (!occupiedSeatInSight) {
                        char[] lineAsCharArray = mapCopy.get(i).toCharArray();
                        lineAsCharArray[j] = '#';
                        mapCopy.set(i, String.copyValueOf(lineAsCharArray));
                    }
                }
            }
        }

        return mapCopy;
    }

    private static List<String> secondRuleV2(List<String> map) {
        List<String> mapCopy = new ArrayList<>(map);

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length(); j++) {
                int occupiedSeatCount = 0;

                if (map.get(i).charAt(j) == '#') {
                    //check up
                    for (int k = i - 1; k >= 0; k--) {
                        if (map.get(k).charAt(j) == '#'){
                            occupiedSeatCount++;
                            k = 0;
                        }
                        else if (map.get(k).charAt(j) == 'L')
                            k = 0;
                    }


                    //check down
                    for (int k = i + 1; k < map.size(); k++) {
                        if (map.get(k).charAt(j) == '#'){
                            occupiedSeatCount++;
                            k = map.size();
                        }
                        else if (map.get(k).charAt(j) == 'L')
                            k = map.size();
                    }


                    //check left
                    for (int k = j - 1; k >= 0; k--) {
                        if (map.get(i).charAt(k) == '#'){
                            occupiedSeatCount++;
                            k = 0;
                        }
                        else if (map.get(i).charAt(k) == 'L')
                            k = 0;
                    }


                    //check right
                    for (int k = j + 1; k < map.get(i).length(); k++){
                        if (map.get(i).charAt(k) == '#'){
                            occupiedSeatCount++;
                            k = map.get(i).length();
                        }
                        else if (map.get(i).charAt(k) == 'L')
                            k = map.get(i).length();
                    }


                    //check diagonal up-left
                    for (int k = 1; (i - k >= 0) && (j - k >= 0); k++) {
                        if (map.get(i-k).charAt(j-k) == '#'){
                            occupiedSeatCount++;
                            k = map.get(i).length();
                        }
                        else if (map.get(i - k).charAt(j - k) == 'L')
                            k = map.get(i).length();
                    }


                    //check diagonal up-right
                    for (int k = 1; (i - k >= 0) && (j + k < map.get(i - k).length()); k++) {
                        if (map.get(i-k).charAt(j+k) == '#'){
                            occupiedSeatCount++;
                            k = map.get(i).length();
                        }
                        else if (map.get(i - k).charAt(j + k) == 'L')
                            k = map.get(i).length();
                    }


                    //check diagonal down-left
                    for (int k = 1; (i + k < map.size()) && (j - k >= 0); k++) {
                        if (map.get(i+k).charAt(j-k) == '#'){
                            occupiedSeatCount++;
                            k = map.get(i).length();
                        }
                        else if (map.get(i + k).charAt(j - k) == 'L')
                            k = map.get(i).length();
                    }


                    //check diagonal down-right
                    for (int k = 1; (i + k < map.size()) && (j + k < map.get(i + k).length()); k++) {
                        if (map.get(i+k).charAt(j+k) == '#'){
                            occupiedSeatCount++;
                            k = map.get(i).length();
                        }
                        else if (map.get(i + k).charAt(j + k) == 'L')
                            k = map.get(i).length();
                    }

                    if (occupiedSeatCount >= 5) {
                        char[] line = mapCopy.get(i).toCharArray();
                        line[j] = 'L';
                        mapCopy.set(i, String.copyValueOf(line));
                    }
                }
            }
        }

        return mapCopy;
    }

}
