package de.tanschmi.aoc2024.dec16;

public class State {
    int row, col, cost, direction; // Aktuelle Position, Kosten, Richtung

    State(int row, int col, int cost, int direction) {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Col: " + col + ", $" + cost + ", Direction: " + directionToString(direction);
    }

    String directionToString(int direction) {
        switch (direction) {
            case 0:
                return "> EAST";
            case 1:
                return "v SOUTH";
            case 2:
                return "< WEST";
            case 3:
                return "^ NORTH";
        }
        return "";
    }
}

