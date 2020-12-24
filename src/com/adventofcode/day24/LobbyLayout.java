package com.adventofcode.day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LobbyLayout {

    public static long countBlackTilesAfterIntructions(List<Intruction> instructionList) {
        Map<Coordinate, Color> lobbyMap = new HashMap<>();

        for (Intruction instructions : instructionList) {
            int q = 0;
            int r = 0;

            for (String move : instructions.getInstructions()) {
                if (move.equals("ne")) {
                    q++;
                    r--;
                }
                if (move.equals("e")) {
                    q++;
                }
                if (move.equals("se")) {
                    r++;
                }
                if (move.equals("sw")) {
                    q--;
                    r++;
                }
                if (move.equals("w")) {
                    q--;
                }
                if (move.equals("nw")) {
                    r--;
                }
            }
            flipColor(lobbyMap, q, r);
        }

        return lobbyMap.values().stream()
                .filter(color -> color == Color.BLACK)
                .count();
    }

    private static void flipColor(Map<Coordinate, Color> lobbyMap, int q, int r) {
        Optional<Coordinate> optionalMatchingCoordinate = lobbyMap.keySet().stream()
                .filter(coordinate -> coordinate.q == q && coordinate.r == r)
                .findFirst();
        if (optionalMatchingCoordinate.isPresent()) {
            Coordinate matchingCoordinate = optionalMatchingCoordinate.get();
            if (lobbyMap.get(matchingCoordinate) == Color.BLACK) {
                lobbyMap.put(matchingCoordinate, Color.WHITE);
            } else {
                lobbyMap.put(matchingCoordinate, Color.BLACK);
            }
        } else {
            lobbyMap.put(new Coordinate(q, r), Color.BLACK);
        }
    }

}
