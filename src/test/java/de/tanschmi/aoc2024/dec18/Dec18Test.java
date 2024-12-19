package de.tanschmi.aoc2024.dec18;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class Dec18Test {
    final Dec18 dec18 = new Dec18();
    final String example = """
            5,4
            4,2
            4,5
            3,0
            2,1
            6,3
            2,4
            1,5
            0,6
            3,3
            2,6
            5,1
            1,2
            5,5
            2,5
            6,5
            1,4
            0,4
            6,4
            1,1
            6,1
            1,0
            0,5
            1,6
            2,0""";

    @Test
    void task1() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec18.txt").getFile());
        String input = FileUtils.readFileToString(inFile, Charset.defaultCharset());

        long result = dec18.task1(input, 71, 1024);
        assertEquals(272, result);
    }

    @Test
    void task1_example() {
        long result = dec18.task1(example, 7, 12);
        assertEquals(22, result);
    }

    @Test
    void task2_example() {
        Coord coord = dec18.task2(example, 7, 12);
        assertNotNull(coord);
        log.info("Coord {},{}", coord.row, coord.col);
        assertEquals("6,1", coord.toString());
    }

    @Test
    void task2() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec18.txt").getFile());
        String input = FileUtils.readFileToString(inFile, Charset.defaultCharset());

        Coord result = dec18.task2(input, 71, 1024);
        assertEquals("16,44", result.toString());
    }
}