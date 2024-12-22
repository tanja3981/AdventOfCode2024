package de.tanschmi.aoc2024.dec22;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

public class Dec22Test {

    @Test
    void nextSecret() {

        Dec22 dec22 = new Dec22();

        long result = dec22.nextSecret(123);
        assertEquals(15887950, result);
        result = dec22.nextSecret(result);
        assertEquals(16495136, result);
        result = dec22.nextSecret(result);
        assertEquals(527345, result);
        result = dec22.nextSecret(result);
        assertEquals(704524, result);
        result = dec22.nextSecret(result);
        assertEquals(1553684, result);
        result = dec22.nextSecret(result);
        assertEquals(12683156, result);
        result = dec22.nextSecret(result);
        assertEquals(11100544, result);
        result = dec22.nextSecret(result);
        assertEquals(12249484, result);
        result = dec22.nextSecret(result);
        assertEquals(7753432, result);
        result = dec22.nextSecret(result);
        assertEquals(5908254, result);
    }

    @Test
    void testXor() {
        int secret = 42;
        int result = 15;

        secret = secret ^ result;
        assertEquals(37, secret);

    }

    @Test
    void task1_example() {
        String input = """
                1
                10
                100
                2024""";
        Dec22 dec22 = new Dec22();
        long result = dec22.task1(input, 2000);
        assertEquals(37327623, result);
    }

    @Test
    void task1() throws IOException {
        File file = new File(ClassLoader.getSystemResource("inputs/dec22.txt").getFile());
        String input = FileUtils.readFileToString(file, Charset.defaultCharset());

        Dec22 dec22 = new Dec22();
        long result = dec22.task1(input, 2000);
        assertEquals(14691757043L, result);
    }
}