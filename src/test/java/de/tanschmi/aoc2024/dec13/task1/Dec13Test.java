package de.tanschmi.aoc2024.dec13.task1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec13Test {
    final Dec13 dec13 = new Dec13();

    @Test
    void task1() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec13.txt").getFile());

        long result = dec13.task1(inFile);
        assertEquals(34787, result);
    }

    @Test
    void task1_withExample() {
        String example = """
                Button A: X+94, Y+34
                Button B: X+22, Y+67
                Prize: X=8400, Y=5400
                
                Button A: X+26, Y+66
                Button B: X+67, Y+21
                Prize: X=12748, Y=12176
                
                Button A: X+17, Y+86
                Button B: X+84, Y+37
                Prize: X=7870, Y=6450
                
                Button A: X+69, Y+23
                Button B: X+27, Y+71
                Prize: X=18641, Y=10279""";


        long result = dec13.task1(example);
        assertEquals(480L, result);
    }
}