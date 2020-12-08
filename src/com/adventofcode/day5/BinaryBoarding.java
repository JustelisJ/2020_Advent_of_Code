package com.adventofcode.day5;

import java.util.*;

public class BinaryBoarding {

    public int findHighestID(List<String> boardingPasses){
        int highest = 0;
        for (String boardingPass : boardingPasses){
            int id = findId(boardingPass);
            if(id > highest)
                highest = id;
        }
        return highest;
    }

    private int findId(String boardingPass){
        String binaryValue = boardingPass.replace('B', '1').replace('F', '0')
                .replace('R', '1').replace('L', '0');
        int row = Integer.parseInt(binaryValue.substring(0, 7), 2);
        int column = Integer.parseInt(binaryValue.substring(7, binaryValue.length()),2);

        return (row * 8) + column;
    }

    public int findEmptySeat(List<String> boardingPasses){
        int emptySeatID = -1;
        Set<Integer>takenSeats = new TreeSet<>();
        boardingPasses.forEach(boardingPass -> takenSeats.add(findId(boardingPass)));
        Integer[] takenSeatArray = new Integer[takenSeats.size()];
        takenSeats.toArray(takenSeatArray);
        for(int i = 1; i < takenSeatArray.length - 1; i++){
            if((takenSeatArray[i] != takenSeatArray[i-1]+1) || (takenSeatArray[i] != takenSeatArray[i+1]-1)) {
                emptySeatID = takenSeatArray[i] + 1;
                break;
            }
        }
        return emptySeatID;
    }

}
