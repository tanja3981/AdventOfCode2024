package de.tanschmi.aoc2024.dec4;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dec4Test {
    final Dec4 service = new Dec4();

    @Test
    void task1() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec4.txt").getFile());

        int result = service.task1(f);
        assertEquals(2599, result);
    }

    @Test
    void task1_example() {
        String text = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX""";
        int result = service.task1(text);
        assertEquals(18, result);
    }

    @Test
    void task2() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec4.txt").getFile());

        int result = service.task2(f);
        assertEquals(1948, result);

    }

    @Test
    void task2_example() {
        String text = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX""";
        int result = service.task2(text);
        assertEquals(9, result);
    }
}