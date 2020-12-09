package com.adventofcode.day8;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("day8.txt")) {
            List<Operation> operations = toStringStream(input).map(line -> {
                String[] splitLine = line.split(" ");
                if (splitLine[1].charAt(0) == '+')
                    return new Operation(splitLine[0], Integer.parseInt(splitLine[1].substring(1)));
                else
                    return new Operation(splitLine[0], Integer.parseInt(splitLine[1]));
            }).collect(Collectors.toList());

            Operation operation = new Operation("", 0);
            System.out.println(operation.calculateTheAcc(operations));
            System.out.println(operation.changingOneOperation(operations));
        }
    }

    public static Stream<String> toStringStream(InputStream batch) {
        return new Scanner(batch)
                .useDelimiter("\n")
                .tokens();
    }

}
