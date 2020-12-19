package com.adventofcode.day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/resource", "day18.txt"))) {
            while (scanner.hasNextLine()) {
                String math = scanner.nextLine();
                math = math.replace(" ", "");
                System.out.println(OperationOfOrder.calculateMathLine(math));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
