package de.tanschmi.aoc2024.dec10;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static de.tanschmi.aoc2024.AbstractAdventOfCodeTest.loadInput;
import static org.junit.jupiter.api.Assertions.*;

class Dec10Test {
    private final Dec10 dec10 = new Dec10();

    @Test
    void task1() throws IOException {
        String input = loadInput("inputs/dec10.txt");
        long result = dec10.task1(input);
        assertEquals(733, result);
    }

    @Test
    void task1_example() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732""";

        long result = dec10.task1(input);
        assertEquals(36L, result);
    }

    @Test
    void task1_smallExample() {
        String input = """
                10..9..
                2...8..
                3...7..
                4567654
                ...8..3
                ...9..2
                .....01""";
        long result = dec10.task1(input);
        assertEquals(3L, result);
    }

      @Test
    void task1_smallExample2() {
        String input = """
                ..90..9
                ...1.98
                ...2..7
                6543456
                765.987
                876....
                987....""";
          long result = dec10.task1(input);
          assertEquals(4L, result);
      }



}