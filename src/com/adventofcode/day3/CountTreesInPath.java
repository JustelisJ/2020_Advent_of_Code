package com.adventofcode.day3;

import java.util.List;

public class CountTreesInPath {

    public int countTreeOnPath(List<String> map, int stepsRight, int stepsDown){
        int treeCount = 0;
        int horizontalLocation = 0;
        for(int i = stepsDown; i < map.size(); i = i + stepsDown){
            horizontalLocation = (horizontalLocation + stepsRight) % map.get(i).length();
            if(map.get(i).charAt(horizontalLocation) == '#'){
                treeCount++;
            }
        }
        return treeCount;
    }

}
