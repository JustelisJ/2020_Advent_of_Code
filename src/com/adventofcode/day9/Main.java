package com.adventofcode.day9;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static final int PREAMPLE = 25;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/resource", "day9.txt"));
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            String longAsString = scanner.next();
            numbers.add(Long.parseLong(longAsString));
        }
        System.out.println(EncodingError.twoNumberSumSearch(numbers));
        System.out.println(EncodingError.addSmallestAndLargestNumberFromSetThatAddsUpToInvalidNumber(numbers,
                EncodingError.twoNumberSumSearch(numbers)));
    }

    public static Stream<String> toStringStream(InputStream batch) {
        return new Scanner(batch)
                .useDelimiter("\n")
                .tokens();
    }

}
