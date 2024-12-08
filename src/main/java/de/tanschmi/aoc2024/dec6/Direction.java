package de.tanschmi.aoc2024.dec6;

import lombok.Getter;

public enum Direction {
    UP('^'),
    RIGHT('>'),
    DOWN('v'),
    LEFT('<');

    @Getter
    char value ;
    Direction(char value) {
        this.value = value;
    }

    public char value() {
        return value;
    }
}
