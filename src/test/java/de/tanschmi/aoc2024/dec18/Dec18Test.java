package de.tanschmi.aoc2024.dec18;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec18Test {
    final Dec18 dec18 = new Dec18();

    @Test
    void task1() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec18.txt").getFile());
        String input = FileUtils.readFileToString(inFile, Charset.defaultCharset());

        long result = dec18.task1(input, 71, 1024);
        assertEquals(272, result);
    }

    @Test
    void task1_example() {
        String input = """
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

        long result = dec18.task1(input, 7, 12);
        assertEquals(22, result);

    }
}