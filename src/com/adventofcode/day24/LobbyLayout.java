package com.adventofcode.day24;

import java.util.*;

public class LobbyLayout {

    public static long countBlackTilesAfterIntructions(List<Intruction> instructionList) {
        Map<Coordinate, Color> lobbyMap = createTheInitialMap(instructionList);

        return lobbyMap.values().stream()
                .filter(color -> color == Color.BLACK)
                .count();
    }

    private static Map<Coordinate, Color> createTheInitialMap(List<Intruction> instructionList) {
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
        return lobbyMap;
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

    public static long blackTileCountAfter100Days(List<Intruction> instructionList) {
        Map<Coordinate, Color> lobbyMap = createTheInitialMap(instructionList);

        for (int i = 0; i < 1; i++) {
            expandMap(lobbyMap);
            Map<Coordinate, Color> lobbyMapCopy = new HashMap<>(lobbyMap);
            for (Coordinate coordinate : lobbyMap.keySet()) {
                Color tileColor = lobbyMap.get(coordinate);
                long adjacentBlackTileCount = countAdjacentBlackTiles(lobbyMap, coordinate);
                if ((tileColor == Color.BLACK) && ((adjacentBlackTileCount == 0) || (adjacentBlackTileCount > 2))) {
                    lobbyMapCopy.put(coordinate, Color.WHITE);
                }
                if ((tileColor == Color.WHITE) && (adjacentBlackTileCount == 2)) {
                    lobbyMapCopy.put(coordinate, Color.BLACK);
                }
            }
            lobbyMap = lobbyMapCopy;
        }

        return lobbyMap.values().stream()
                .filter(color -> color == Color.BLACK)
                .count();
    }

    private static long countAdjacentBlackTiles(Map<Coordinate, Color> lobbyMap, Coordinate coordinate) {
        int q = coordinate.q;
        int r = coordinate.r;

        return lobbyMap.keySet().stream()
                .filter(coordinate1 ->
                        ((coordinate1.q + 1 == q) && (coordinate1.r - 1 == r)) ||
                                ((coordinate1.q + 1 == q) && (coordinate1.r == r)) ||
                                ((coordinate1.q == q) && (coordinate1.r + 1 == r)) ||
                                ((coordinate1.q - 1 == q) && (coordinate1.r + 1 == r)) ||
                                ((coordinate1.q - 1 == q) && (coordinate1.r == r)) ||
                                ((coordinate1.q == q) && (coordinate1.r - 1 == r)))
                .filter(coordinate1 -> lobbyMap.get(coordinate1) == Color.BLACK)
                .count();
    }

    private static void expandMap(Map<Coordinate, Color> lobbyMap) {
        Optional<Integer> optionalMaxQ = lobbyMap.keySet().stream()
                .map(Coordinate::getQ)
                .max(Comparator.naturalOrder());
        Optional<Integer> optionalMaxR = lobbyMap.keySet().stream()
                .map(Coordinate::getR)
                .max(Comparator.naturalOrder());

        if (optionalMaxQ.isEmpty() || optionalMaxR.isEmpty())
            return;

        int maxQ = optionalMaxQ.get() + 1;
        int maxR = optionalMaxR.get() + 1;

        //fill upper line
        for (int q = 0; q < maxQ; q++) {
            lobbyMap.put(new Coordinate(q, maxR * -1), Color.WHITE);
        }
        //fill upper right
        for (int r = maxR * -1; r < 0; r++) {
            lobbyMap.put(new Coordinate(maxQ, r), Color.WHITE);
        }
        //fill lower right
        for (int i = 0; i < maxR; i++) {
            lobbyMap.put(new Coordinate(maxQ - i, i), Color.WHITE);
        }
        //fill lower line
        for (int q = 0; q > maxQ * -1; q--) {
            lobbyMap.put(new Coordinate(q, maxR), Color.WHITE);
        }
        //fill lower left
        for (int r = maxR; r > 0; r--) {
            lobbyMap.put(new Coordinate(maxQ * -1, r), Color.WHITE);
        }
        //fill upper left
        for (int i = 0; i < maxR; i++) {
            lobbyMap.put(new Coordinate(maxQ * -1 + i, i * -1), Color.WHITE);
        }

    }

}
