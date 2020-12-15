package com.adventofcode.day12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RainRiskTest {

    @Test
    void xandYCoordinateSumWithWaypointNorthOperation() {
        List<NavigationInstruction> instructions = new ArrayList<>();
        instructions.add(new NavigationInstruction('N', 10));
        instructions.add(new NavigationInstruction('F', 1));
        assertEquals(21, RainRisk.XandYCoordinateSumWithWaypoint(instructions));
    }

    @Test
    void xandYCoordinateSumWithWaypointSouthOperation() {
        List<NavigationInstruction> instructions = new ArrayList<>();
        instructions.add(new NavigationInstruction('S', 10));
        instructions.add(new NavigationInstruction('F', 1));
        assertEquals(19, RainRisk.XandYCoordinateSumWithWaypoint(instructions));
    }

    @Test
    void xandYCoordinateSumWithWaypointEastOperation() {
        List<NavigationInstruction> instructions = new ArrayList<>();
        instructions.add(new NavigationInstruction('E', 10));
        instructions.add(new NavigationInstruction('F', 1));
        assertEquals(21, RainRisk.XandYCoordinateSumWithWaypoint(instructions));
    }

    @Test
    void xandYCoordinateSumWithWaypointWestOperation() {
        List<NavigationInstruction> instructions = new ArrayList<>();
        instructions.add(new NavigationInstruction('W', 10));
        instructions.add(new NavigationInstruction('F', 1));
        assertEquals(1, RainRisk.XandYCoordinateSumWithWaypoint(instructions));
    }

    @Test
    void xandYCoordinateSumWithWaypointLeftOperation() {
        Coordinate coordinate = new Coordinate(1, 3);

        Coordinate rotation90Degree = Coordinate.rotateLeft(coordinate, 90);
        assertEquals(-3, rotation90Degree.x);
        assertEquals(1, rotation90Degree.y);

        Coordinate rotation180Degree = Coordinate.rotateLeft(coordinate, 180);
        assertEquals(-1, rotation180Degree.x);
        assertEquals(-3, rotation180Degree.y);

        Coordinate rotation270Degree = Coordinate.rotateLeft(coordinate, 270);
        assertEquals(3, rotation270Degree.x);
        assertEquals(-1, rotation270Degree.y);
    }

    @Test
    void xandYCoordinateSumWithWaypointRightOperation() {
        Coordinate coordinate = new Coordinate(1, 3);

        Coordinate rotation90Degree = Coordinate.rotateRight(coordinate, 90);
        assertEquals(3, rotation90Degree.x);
        assertEquals(-1, rotation90Degree.y);

        Coordinate rotation180Degree = Coordinate.rotateRight(coordinate, 180);
        assertEquals(-1, rotation180Degree.x);
        assertEquals(-3, rotation180Degree.y);

        Coordinate rotation270Degree = Coordinate.rotateRight(coordinate, 270);
        assertEquals(-3, rotation270Degree.x);
        assertEquals(1, rotation270Degree.y);


        Coordinate coordinate2 = new Coordinate(-10, 15);

        Coordinate rotation90Degree2 = Coordinate.rotateRight(coordinate2, 90);
        assertEquals(3, rotation90Degree.x);
        assertEquals(-1, rotation90Degree.y);

        Coordinate rotation180Degree2 = Coordinate.rotateRight(coordinate2, 180);
        assertEquals(-1, rotation180Degree.x);
        assertEquals(-3, rotation180Degree.y);

        Coordinate rotation270Degree2 = Coordinate.rotateRight(coordinate2, 270);
        assertEquals(-3, rotation270Degree.x);
        assertEquals(1, rotation270Degree.y);
    }

    @Test
    void xandYCoordinateSumWithWaypointForwardOperation() {
        List<NavigationInstruction> instructions = new ArrayList<>();
        instructions.add(new NavigationInstruction('F', 10));
        assertEquals(110, RainRisk.XandYCoordinateSumWithWaypoint(instructions));
    }

    @Test
    void rotateLeftThenRightAndStayTheSame() {
        
    }
}