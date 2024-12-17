package de.tanschmi.aoc2024.dec16;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec16Test {
    Dec16 dec16 = new Dec16();
    @Test
    void task1_ex1() {
        String input = """
                ###############
                #.......#....E#
                #.#.###.#.###.#
                #.....#.#...#.#
                #.###.#####.#.#
                #.#.#.......#.#
                #.#.#####.###.#
                #...........#.#
                ###.#.#####.#.#
                #...#.....#.#.#
                #.#.#.###.#.#.#
                #.....#...#.#.#
                #.###.#.#.#.#.#
                #S..#.....#...#
                ###############""";

        int result = dec16.task(Task.TASK1, input);
        assertEquals(7036, result);
    }

    @Test
    void task1_ex2() {
        String input = """
                #################
                #...#...#...#..E#
                #.#.#.#.#.#.#.#.#
                #.#.#.#...#...#.#
                #.#.#.#.###.#.#.#
                #...#.#.#.....#.#
                #.#.#.#.#.#####.#
                #.#...#.#.#.....#
                #.#.#####.#.###.#
                #.#.#.......#...#
                #.#.###.#####.###
                #.#.#...#.....#.#
                #.#.#.#####.###.#
                #.#.#.........#.#
                #.#.#.#########.#
                #S#.............#
                #################""";

        int result = dec16.task(Task.TASK1, input);
        assertEquals(11048, result);
    }

    @Test
    void task1() throws IOException {
        File infile = new File(ClassLoader.getSystemResource("inputs/dec16.txt").getFile());
        String input = FileUtils.readFileToString(infile, Charset.defaultCharset());

        int result = dec16.task(Task.TASK1, input);
        assertEquals(85420, result);
    }

    @Test
    void task2_ex1() {
        String input = """
                ###############
                #.......#....E#
                #.#.###.#.###.#
                #.....#.#...#.#
                #.###.#####.#.#
                #.#.#.......#.#
                #.#.#####.###.#
                #...........#.#
                ###.#.#####.#.#
                #...#.....#.#.#
                #.#.#.###.#.#.#
                #.....#...#.#.#
                #.###.#.#.#.#.#
                #S..#.....#...#
                ###############""";

        int result = dec16.task(Task.TASK2, input);
        assertEquals(45, result);
    }
}