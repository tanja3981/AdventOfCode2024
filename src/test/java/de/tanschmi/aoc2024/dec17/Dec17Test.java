package de.tanschmi.aoc2024.dec17;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dec17Test {

    @Test
    void test_C9_26() {
        ChronospatialComputer c = ChronospatialComputer.builder()
                .registerC(9)
                .program(new ArrayList<>(Arrays.asList(2, 6)))
                .build();

        Dec17 d = new Dec17();
        d.task1(c);

        assertEquals(1, c.registerB);
    }

    @Test
    void test_A10_505154() {
        ChronospatialComputer c = ChronospatialComputer.builder()
                .registerA(10)
                .program(new ArrayList<>(Arrays.asList(5, 0, 5, 1, 5, 4)))
                .build();

        Dec17 d = new Dec17();
        String out = d.task1(c);
        assertEquals("0,1,2", out);
    }

    @Test
    void test_A2024_015430() {
        ChronospatialComputer c = ChronospatialComputer
                .builder()
                .registerA(2024)
                .program(new ArrayList<>(Arrays.asList(0, 1, 5, 4, 3, 0)))
                .build();
        Dec17 d = new Dec17();
        String out = d.task1(c);
        assertEquals(0, c.registerA);
        assertEquals("4,2,5,6,7,7,7,7,3,1,0", out);
    }

    @Test
    void test_B29_17() {
        ChronospatialComputer c = ChronospatialComputer
                .builder()
                .registerB(29)
                .program(new ArrayList<>(Arrays.asList(1, 7)))
                .build();
        Dec17 d = new Dec17();
        d.task1(c);
        assertEquals(26, c.registerB);
    }

    @Test
    void test_B2024_C43690_40() {
        ChronospatialComputer c = ChronospatialComputer
                .builder()
                .registerB(2024)
                .registerC(43690)
                .program(new ArrayList<>(Arrays.asList(4, 0)))
                .build();
        Dec17 d = new Dec17();
        d.task1(c);
        assertEquals(44354, c.registerB);
    }

    @Test
    void task1_example() {
        String input = """
                Register A: 729
                Register B: 0
                Register C: 0
                
                Program: 0,1,5,4,3,0""";

        Dec17 d = new Dec17();
        ChronospatialComputer computer = new Dec17Reader().read(input);
        String out = d.task1(computer);
        assertEquals("4,6,3,5,6,3,5,2,1,0", out);
    }

    @Test
    void task1() {
        String input = """
                Register A: 47792830
                Register B: 0
                Register C: 0
                
                Program: 2,4,1,5,7,5,1,6,4,3,5,5,0,3,3,0""";

        ChronospatialComputer computer = new Dec17Reader().read(input);
        Dec17 d = new Dec17();
        String out = d.task1(computer);
        System.out.println(out);
        assertEquals("2,1,3,0,5,2,3,7,1", out);

    }
}