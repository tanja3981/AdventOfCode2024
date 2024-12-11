package de.tanschmi.aoc2024.dec11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dec11Test {
    final Dec11 service = new Dec11();

    @Test
    void task1() {
        final String input = "28591 78 0 3159881 4254 524155 598 1";
        int result = service.task1(input, 25);

        assertEquals(220722, result);
    }

    @Test
    void task1_example() {
        final String input = "125 17";

        int result = service.task1(input, 25);
        assertEquals(55312, result);

    }

    @Test
    void splitStone() {

        Long[] result = service.splitStone("2024");

        assertEquals(2, result.length);
        assertEquals(20L, result[0]);
        assertEquals(24L, result[1]);

        result = service.splitStone("1000");
        assertEquals(2, result.length);
        assertEquals(10L, result[0]);
        assertEquals(0L, result[1]);
    }
}