package de.tanschmi.aoc2024.dec6;

import lombok.Getter;
import lombok.Setter;

import static de.tanschmi.aoc2024.dec6.Direction.*;

public class Coord {
    @Getter
    @Setter
    int row, col;
    @Getter
    @Setter
    Direction dir;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coord(int row, int col, Direction dir) {
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    Coord move() {
        switch (dir) {
            case UP:
                return new Coord(row - 1, col, dir);
            case RIGHT:
                return new Coord(row, col + 1, dir);
            case DOWN:
                return new Coord(row + 1, col, dir);
            case LEFT:
                return new Coord(row, col - 1, dir);
            default:
                throw new RuntimeException("Unbekannte Richtung " + dir);
        }
    }

    Coord turn() {
        switch (dir) {
            case UP:
                return new Coord(row, col, RIGHT);
            case RIGHT:
                return new Coord(row, col, DOWN);
            case DOWN:
                return new Coord(row, col, LEFT);
            case LEFT:
                return new Coord(row, col, UP);
            default:
                throw new RuntimeException("Unbekannte Richtung " + dir);
        }
    }

    @Override
    public String toString() {
        return row + ":" + col + " " + dir;
    }
}
