package com.adventofcode.day14;

public class Memory {

    private final int location;
    private final long decimalValue;
    private String bitMaskedBinaryValue;

    public Memory(int location, long decimalValue) {
        this.location = location;
        this.decimalValue = decimalValue;
    }

    public int getLocation() {
        return location;
    }

    public long getDecimalValue() {
        return decimalValue;
    }

    public String getBitMaskedBinaryValue() {
        return bitMaskedBinaryValue;
    }

    public void setBitMaskedBinaryValue(String bitMaskedBinaryValue) {
        this.bitMaskedBinaryValue = bitMaskedBinaryValue;
    }
}
