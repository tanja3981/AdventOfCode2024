package de.tanschmi.aoc2024.dec6;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Dec6Task1Test {

    @Test
    void task1() throws Exception {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec6.txt").getFile());

        Dec6Task1 dec6 = new Dec6Task1();
        int result = dec6.task1(inFile);

        assertEquals(4663, result);
    }

    @Test
    void task1_example() throws Exception {
        String text = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...""";

        Dec6Task1 dec6 = new Dec6Task1();

        int result = dec6.task1(text);
        assertEquals(41, result);
        assertEquals(41, result);
    }

}