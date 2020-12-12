package com.adventofcode.day12;

import java.util.List;

import static java.lang.Math.abs;

public class RainRisk {

    public static int XandYCoordinateSum(List<NavigationInstruction> instructions){
        int x = 0;
        int y = 0;
        int dir = 90;

        for(NavigationInstruction instruction : instructions){
            if(instruction.instruction == 'N'){
                y += instruction.value;
            }
            else if(instruction.instruction == 'S'){
                y -= instruction.value;
            }
            else if(instruction.instruction == 'E'){
                x += instruction.value;
            }
            else if(instruction.instruction == 'W'){
                x -= instruction.value;
            }
            else if(instruction.instruction == 'L'){
                dir -= instruction.value;
                if(dir < 0){
                    dir = 360 + dir;
                }
            }
            else if(instruction.instruction == 'R'){
                dir += instruction.value;
                dir %= 360;
            }
            else if(instruction.instruction == 'F'){
                if(dir == 0){
                    y += instruction.value;
                }
                else if(dir == 90){
                    x += instruction.value;
                }
                else if(dir == 180){
                    y -= instruction.value;
                }
                else if(dir == 270){
                    x -= instruction.value;
                }
                else {
                    System.out.println("Need more degree ifs");
                }
            }
        }

        return abs(x) + abs(y);
    }

    public static int XandYCoordinateSumWithWaypoint(List<NavigationInstruction> instructions){
        int xShip = 0;
        int yShip = 0;
        int xWaypoint = 10;
        int yWaypoint = 1;

        for(NavigationInstruction instruction : instructions){
            if(instruction.instruction == 'N'){
                yWaypoint += instruction.value;
            }
            else if(instruction.instruction == 'S'){
                yWaypoint -= instruction.value;
            }
            else if(instruction.instruction == 'E'){
                xWaypoint += instruction.value;
            }
            else if(instruction.instruction == 'W'){
                xWaypoint -= instruction.value;
            }
            else if(instruction.instruction == 'L'){
                Coordinate rotatedCoordinates = Coordinate.rotateLeft(
                        new Coordinate(xWaypoint, yWaypoint), instruction.value);
                xWaypoint = rotatedCoordinates.x;
                yWaypoint = rotatedCoordinates.y;
            }
            else if(instruction.instruction == 'R'){
                Coordinate rotatedCoordinates = Coordinate.rotateRight(
                        new Coordinate(xWaypoint, yWaypoint), instruction.value);
                xWaypoint = rotatedCoordinates.x;
                yWaypoint = rotatedCoordinates.y;
            }
            else if(instruction.instruction == 'F'){
                xShip += xWaypoint * instruction.value;
                yShip += yWaypoint * instruction.value;
            }
        }

        return abs(xShip) + abs(yShip);
    }
}

class Coordinate{

    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Coordinate rotateLeft(Coordinate coordinate, int degrees){
        int x = 0;
        int y = 0;

        if(degrees == 90){
            x = coordinate.y * -1;
            y = coordinate.x;
        }
        if(degrees == 180){
            //I quadrant and III quadrant
            if(((coordinate.x > 0) && (coordinate.y > 0)) || ((coordinate.x < 0) && (coordinate.y < 0))){
                x = coordinate.x * -1;
                y = coordinate.y * -1;
            }
            //II quadrant and IV quadrant
            if(((coordinate.x < 0) && (coordinate.y > 0)) || ((coordinate.x > 0) && (coordinate.y < 0))){
                x = coordinate.x;
                y = coordinate.y;
            }
        }
        if(degrees == 270){
            x = coordinate.y;
            y = coordinate.x * -1;
        }

        return new Coordinate(x, y);
    }

    public static Coordinate rotateRight(Coordinate coordinate, int degrees){
        int x = 0;
        int y = 0;

        if(degrees == 90){
            x = coordinate.y;
            y = coordinate.x * -1;
        }
        if(degrees == 180){
            //I quadrant and III quadrant
            if(((coordinate.x > 0) && (coordinate.y > 0)) || ((coordinate.x < 0) && (coordinate.y < 0))){
                x = coordinate.x * -1;
                y = coordinate.y * -1;
            }
            //II quadrant and IV quadrant
            if(((coordinate.x < 0) && (coordinate.y > 0)) || ((coordinate.x > 0) && (coordinate.y < 0))){
                x = coordinate.x;
                y = coordinate.y;
            }
        }
        if(degrees == 270){
            x = coordinate.y * -1;
            y = coordinate.x;
        }

        return new Coordinate(x, y);
    }
}

