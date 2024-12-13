package de.tanschmi.aoc2024.dec13.task2;

import de.tanschmi.aoc2024.dec13.task1.Loc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2ParserTest {
    final Task2Parser parser = new Task2Parser();

    @Test
    void parsePrizeForTask2() {
        String in = "Prize: X=8400, Y=5400\n";
        Loc loc = parser.parsePrize(in);
        assertEquals(10000000008400L, loc.getX());
        assertEquals(10000000005400L, loc.getY());

        in = "Prize: X=12748, Y=12176";
        loc = parser.parsePrize(in);
        assertEquals(10000000012748L, loc.getX());
        assertEquals(10000000012176L, loc.getY());

        in = "Prize: X=7870, Y=6450";
        loc = parser.parsePrize(in);
        assertEquals(10000000007870L, loc.getX());
        assertEquals(10000000006450L, loc.getY());

        in = "Prize: X=18641, Y=10279";
        loc = parser.parsePrize(in);
        assertEquals(10000000018641L, loc.getX());
        assertEquals(10000000010279L, loc.getY());
    }
}