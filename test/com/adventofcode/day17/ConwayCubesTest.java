package com.adventofcode.day17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConwayCubesTest {

    List<Character> emptyLine = List.of('.', '.', '.', '.', '.');
    List<Character> xUpper = List.of('.', '.', '#', '.', '.');
    List<Character> xMiddle = List.of('.', '.', '.', '#', '.');
    List<Character> xLower = List.of('.', '#', '#', '#', '.');

    List<List<Character>> map2D = new ArrayList<>();
    List<List<Character>> map2DEmpty = new ArrayList<>();

    List<List<List<Character>>> map3D = new ArrayList<>();

    @BeforeEach
    void setUp() {
        map2D.add(emptyLine);
        map2D.add(xUpper);
        map2D.add(xMiddle);
        map2D.add(xLower);
        map2D.add(emptyLine);

        map2DEmpty.add(emptyLine);
        map2DEmpty.add(emptyLine);
        map2DEmpty.add(emptyLine);
        map2DEmpty.add(emptyLine);
        map2DEmpty.add(emptyLine);

        map3D.add(map2DEmpty);
        map3D.add(map2DEmpty);
        map3D.add(map2D);
        map3D.add(map2DEmpty);
        map3D.add(map2DEmpty);
    }

    @Test
    void countActiveNearbyInitialState() {
        assertEquals(5, ConwayCubes.countActiveNearby(map3D, 2, 2, 2));
    }

    @Test
    void countIn3x3Layer() {
        assertEquals(5, ConwayCubes.countIn3x3Layer(map2D, 2, 2));
        assertEquals(1, ConwayCubes.countIn3x3Layer(map2D, 1, 1));
    }
}