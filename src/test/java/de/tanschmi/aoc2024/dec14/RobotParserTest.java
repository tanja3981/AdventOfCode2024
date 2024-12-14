package de.tanschmi.aoc2024.dec14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RobotParserTest {
    final RobotParser parser = new RobotParser();

    @Test
    void parseText() {

        String in = """
                p=0,4 v=3,-3
                p=6,3 v=-1,-3
                p=10,3 v=-1,2
                p=2,0 v=2,-1
                p=0,0 v=1,3
                p=3,0 v=-2,-2
                p=7,6 v=-1,-3
                p=3,0 v=-1,-2
                p=9,3 v=2,3
                p=7,3 v=-1,2
                p=2,4 v=2,-3
                p=9,5 v=-3,-3
                """;
        ArrayList<Robot> robots = parser.parseText(in);
        assertEquals(12, robots.size());
    }

    @Test
    void getRobot() throws Dec14Exception {
        String in = "p=10,3 v=-1,2";

        Robot robot = parser.getRobot(in);
        assertEquals(10, robot.getInitialX());
        assertEquals(3, robot.getInitialY());
        assertEquals(-1, robot.getVelocityX());
        assertEquals(2, robot.getVelocityY());

        in = "p=7,6 v=-1,-3";
        robot = parser.getRobot(in);
        assertEquals(7, robot.getInitialX());
        assertEquals(6, robot.getInitialY());
        assertEquals(-1, robot.getVelocityX());
        assertEquals(-3, robot.getVelocityY());

        in = "p=0,0 v=1,3";
        robot = parser.getRobot(in);
        assertEquals(0, robot.getInitialX());
        assertEquals(0, robot.getInitialY());
        assertEquals(1, robot.getVelocityX());
        assertEquals(3, robot.getVelocityY());
    }
}