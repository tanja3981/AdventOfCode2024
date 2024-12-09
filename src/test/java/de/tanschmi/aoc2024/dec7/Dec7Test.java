package de.tanschmi.aoc2024.dec7;

import de.tanschmi.aoc2024.dec6.Dec6Task1;
import lombok.SneakyThrows;
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

    @Test
    void task2_exampleText() throws Dec7Exception {
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
        long result = dec7.task2(example);
        assertEquals(11387L, result);
    }

    //@Test
    //TODO: this test takes 10 hours...
    void task2() throws Exception {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec7.txt").getFile());

        Dec7 dec6 = new Dec7();
        long result = dec6.task2(inFile);

        assertEquals(165278151522644L, result);
    }

    @Test
    void testCalculation() {
        Dec7 dec7 = new Dec7();
        boolean flag = dec7.testCalculation("((((((((3) + 4) + 994) + 5) + 92) + 1) || 227) + 79) + 4", 249329);
        assertFalse(flag);
    }
}