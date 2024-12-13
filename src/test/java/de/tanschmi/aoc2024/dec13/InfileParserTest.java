package de.tanschmi.aoc2024.dec13;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InfileParserTest {
    final InfileParser parser = new InfileParser();

    @Test
    void parseA() {
        String in = "Button A: X+94, Y+34";

        Loc loc = parser.parseA(in);

        assertEquals(94, loc.getX());
        assertEquals(34, loc.getY());

        in = "Button A: X+26, Y+66";
        loc = parser.parseA(in);

        assertEquals(26, loc.getX());
        assertEquals(66, loc.getY());

        in = "Button A: X+17, Y+86";
        loc = parser.parseA(in);

        assertEquals(17, loc.getX());
        assertEquals(86, loc.getY());

        in = "Button A: X+69, Y+23";
        loc = parser.parseA(in);

        assertEquals(69, loc.getX());
        assertEquals(23, loc.getY());
    }

    @Test
    void parseB() {
        String in = "Button B: X+22, Y+67";
        Loc loc = parser.parseB(in);
        assertEquals(22, loc.getX());
        assertEquals(67, loc.getY());

        in = "Button B: X+67, Y+21";
        loc = parser.parseB(in);
        assertEquals(67, loc.getX());
        assertEquals(21, loc.getY());

        in = "Button B: X+84, Y+37";
        loc = parser.parseB(in);
        assertEquals(84, loc.getX());
        assertEquals(37, loc.getY());

        in = "Button B: X+27, Y+71";
        loc = parser.parseB(in);
        assertEquals(27, loc.getX());
        assertEquals(71, loc.getY());
    }

    @Test
    void parsePrize() {
        String in = "Prize: X=8400, Y=5400\n";
        Loc loc = parser.parsePrize(in);
        assertEquals(8400, loc.getX());
        assertEquals(5400, loc.getY());

        in = "Prize: X=12748, Y=12176";
        loc = parser.parsePrize(in);
        assertEquals(12748, loc.getX());
        assertEquals(12176, loc.getY());

        in = "Prize: X=7870, Y=6450";
        loc = parser.parsePrize(in);
        assertEquals(7870, loc.getX());
        assertEquals(6450, loc.getY());

        in = "Prize: X=18641, Y=10279";
        loc = parser.parsePrize(in);
        assertEquals(18641, loc.getX());
        assertEquals(10279, loc.getY());
    }

    @Test
    void readFile() throws IOException {
        File inFile = new File(ClassLoader.getSystemResource("inputs/dec13.txt").getFile());

        ArrayList<Claw> claws = parser.readFile(inFile);
        assertEquals(320, claws.size());
    }

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