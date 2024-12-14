package de.tanschmi.aoc2024.dec14;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Dec14Test {
final Dec14 dec14 = new Dec14();

    @Test
    void task1() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec14.txt").getFile());
        String input = FileUtils.readFileToString(inFile, Charset.defaultCharset());

        int reslt = dec14.task1(input, 101, 103, 100);
        assertEquals(230686500, reslt);

    }

    @Test
    void task2() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec14.txt").getFile());
        String input = FileUtils.readFileToString(inFile, Charset.defaultCharset());

        dec14.task2(input, 101, 103, 7672);

    }

    @Test
    void task1_example() {
        String input = """
                p=0,4 v=3,-3
                p=6,3 v=-1,-3
                p=10,3 v=-1,2
                p=2,0 v=2,-1
                p=0,0 v=1,3
                p=3,0 v=-2,-2
                p=7,6 v=-1,-3
                p=3,0 v=-1,-2
                p=9,3 v=2,3
                p=7,3 v=-1,2
                p=2,4 v=2,-3
                p=9,5 v=-3,-3
                """;

        int reslt = dec14.task1(input, 11, 7, 100);
        assertEquals(12, reslt);

    }

}