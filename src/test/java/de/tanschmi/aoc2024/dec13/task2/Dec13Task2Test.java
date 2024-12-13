package de.tanschmi.aoc2024.dec13.task2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Dec13Task2Test {
    Dec13Task2 dec13 = new Dec13Task2();

    @Test
    void task2() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec13.txt").getFile());

        long result = dec13.task2(inFile);
        assertEquals(85644161121698L, result);
    }

    @Test
    void task2_withExample() {
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


        long result = dec13.task2(example);
        assertEquals(480L, result);
    }
}