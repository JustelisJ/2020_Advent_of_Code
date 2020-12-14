package com.adventofcode.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockingData {

    Map<Integer, String> memoryLocationsWithBinary = new HashMap<>();

    public void addAllMemoryValues(String bitmask, List<Memory> memoryList){

        for(Memory memory : memoryList){
            convertDecimalValueToBinary(bitmask, memory);
            memoryLocationsWithBinary.put(memory.getLocation(), memory.getBitMaskedBinaryValue());
        }
    }

    public long getSum() {
        long sum = 0;
        for(String binaryMemoryValue : memoryLocationsWithBinary.values()){
            sum += Long.parseLong(binaryMemoryValue, 2);
        }
        return sum;
    }

    private static void convertDecimalValueToBinary(String bitMask, Memory memory){
        String initialBinary = "000000000000000000000000000000000000";
        char[] initialBinaryAsCharArray = initialBinary.toCharArray();
        String binaryValue = Long.toBinaryString(memory.getDecimalValue());
        for(int i = 0; i < binaryValue.length(); i++){
            initialBinaryAsCharArray[35 - i] = binaryValue.charAt(binaryValue.length() - 1 - i);
        }
        initialBinary = String.copyValueOf(initialBinaryAsCharArray);

        char[] stringAsCharArray = initialBinary.toCharArray();
        for(int i = 0; i < bitMask.length(); i++){
            if(bitMask.charAt(i) != 'X'){
                stringAsCharArray[i] = bitMask.charAt(i);
            }
        }
        memory.setBitMaskedBinaryValue(String.copyValueOf(stringAsCharArray));
    }

}

