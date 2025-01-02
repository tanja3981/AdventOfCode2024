package de.tanschmi.aoc2024.dec12;

import de.tanschmi.aoc2024.AbstractAdventOfCodeTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec12Test{
    private final Dec12 dec12 = new Dec12();
    @Test
    void task1_example() {
        String input = """
                AAAA
                BBCD
                BBCC
                EEEC""";

        long result = dec12.task1(input);
        assertEquals(140, result);
    }

    @Test
    void task1() throws IOException {
        String input = AbstractAdventOfCodeTest.loadInput("inputs/dec12.txt");
        long result = dec12.task1(input);
        assertEquals(1488414, result);
    }

}