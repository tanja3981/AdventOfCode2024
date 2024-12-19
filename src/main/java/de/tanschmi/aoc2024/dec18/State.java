package de.tanschmi.aoc2024.dec18;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class State {
    int row, col;
    State previous;

    @Override
    public String toString() {
        return "Row: " + row + ", Col: " + col;
    }

}

