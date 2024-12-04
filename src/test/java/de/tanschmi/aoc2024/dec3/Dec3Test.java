package de.tanschmi.aoc2024.dec3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec3Test {
    final Dec3 dec3 = new Dec3();

    @Test
    void task1() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec3.txt").getFile());

        int result = dec3.task1(f);
        assertEquals(171183089, result);
    }

    //@Test
    void task2_manual() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec3_step2.txt").getFile());

        int result = dec3.task1(f);
        assertEquals(63866497, result);
    }
    @Test
    void task2() throws IOException {
        File f = new File(ClassLoader.getSystemResource("inputs/dec3.txt").getFile());

        int result = dec3.task2(f);
        assertEquals(63866497, result);
    }


    @Test
    void task2_testExample() {
        final String line = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        int sum = dec3.parseTextWithDoAndDonts(line);
        assertEquals(48, sum);
    }
}