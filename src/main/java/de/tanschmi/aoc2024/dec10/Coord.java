package de.tanschmi.aoc2024.dec10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Coord {
    int row;
    int col;
    Coord previous;

    /**
     * for task 1
     * @param row
     * @param col
     */
    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
        this.previous = null;
    }

    @Override
    public String toString() {
        return row + "," + col + (previous == null ? "" : ", (" + previous.toString() + ")");
    }
}
