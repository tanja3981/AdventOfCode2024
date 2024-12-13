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
    void task2_25times() {
        long result = 0;
        final String input = "28591 78 0 3159881 4254 524155 598 1";
        try {
            result = new Dec11().task2(input, 25);
        } catch (Error e) {
            e.printStackTrace();
        }
        assertEquals(220722, result);

    }

    @Test
    void task2_75times() {
        long result = 0;
        final String input = "28591 78 0 3159881 4254 524155 598 1";
        try {
            result = new Dec11().task2(input, 75);
        } catch (Error e) {
            e.printStackTrace();
        }
        assertEquals(261952051690787L, result);
    }

    @Test
    void task1_example() {
        final String input = "125 17";

        int result = service.task1(input, 25);
        assertEquals(55312, result);

    }

}