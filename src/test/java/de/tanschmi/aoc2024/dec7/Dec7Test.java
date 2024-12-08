package de.tanschmi.aoc2024.dec7;

import de.tanschmi.aoc2024.dec6.Dec6Task1;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Dec7Test {
    @Test
    void task1() throws Exception {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec7.txt").getFile());

        Dec7 dec6 = new Dec7();
        long result = dec6.task1(inFile);

        assertEquals(1582598718861L, result);
    }

    @Test
    void task1_exampleText() throws Dec7Exception {
        final String example = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20""";

        Dec7 dec7 = new Dec7();
        long result = dec7.task1(example);
        assertEquals(3749L, result);
    }


}