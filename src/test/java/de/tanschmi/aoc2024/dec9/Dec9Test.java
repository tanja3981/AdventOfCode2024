package de.tanschmi.aoc2024.dec9;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec9Test {
    final private Dec9 service = new Dec9();

    @Test
    void task1_example() {
        String input = """
                2333133121414131402""";

        long result = service.task1(input);
        assertEquals(1928, result);
    }

    @Test
    void task1() throws IOException {

        File file = new File(ClassLoader.getSystemResource("inputs/dec9.txt").getFile());
        String input = FileUtils.readFileToString(file, Charset.defaultCharset());

        long result = service.task1(input);
        assertEquals(6307275788409L, result);

    }
}