package de.tanschmi.aoc2024.dec19;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dec19Test {
    private final Dec19 dec19 = new Dec19();

    @Test
    void task1() throws IOException {
        File availFile = new File(ClassLoader.getSystemResource("inputs/dec19_available.txt").getFile());
        String available = FileUtils.readFileToString(availFile, Charset.defaultCharset());

        File designsFile = new File(ClassLoader.getSystemResource("inputs/dec19_designs.txt").getFile());
        String designs = FileUtils.readFileToString(designsFile, Charset.defaultCharset());

        int result = dec19.task1(available, designs);
        assertEquals(242, result);

    }

    @Test
    void task1_example() {
        String available = "r, wr, b, g, bwu, rb, gb, br";
        String desings = """
                brwrr
                bggr
                gbbr
                rrbgbr
                ubwu
                bwurrg
                brgr
                bbrgwb
                """;

        int result = dec19.task1(available, desings);
        assertEquals(6, result);
    }
}