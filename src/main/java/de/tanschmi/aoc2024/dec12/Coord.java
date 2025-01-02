package de.tanschmi.aoc2024.dec12;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Coord {
    int row;
    int col;

    @Override
    public String toString() {
        return row + "," + col;
    }
}
