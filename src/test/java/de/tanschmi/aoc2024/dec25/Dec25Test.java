package de.tanschmi.aoc2024.dec25;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec25Test {

    @Test
    void task1() throws IOException {

        File file = new File(ClassLoader.getSystemResource("inputs/dec25.txt").getFile());
        String input = FileUtils.readFileToString(file, Charset.defaultCharset());

        Dec25 dec25 = new Dec25();
        int result = dec25.task1(input);
        assertEquals(2691, result);
    }
}