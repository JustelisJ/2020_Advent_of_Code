package com.adventofcode.day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Intruction> tileFlipIntructions = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File("src/resource", "day24.txt"))) {
            while (scanner.hasNextLine()) {
                tileFlipIntructions.add(new Intruction(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(LobbyLayout.countBlackTilesAfterIntructions(tileFlipIntructions));
        System.out.println(LobbyLayout.blackTileCountAfter100Days(tileFlipIntructions));

    }

}
