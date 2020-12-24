package com.adventofcode.day24;

public class Coordinate {

    int q;
    int r;

    public Coordinate(int q, int r) {
        this.q = q;
        this.r = r;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (q != that.q) return false;
        return r == that.r;
    }

    @Override
    public int hashCode() {
        int result = q;
        result = 31 * result + r;
        return result;
    }
}
