package de.tanschmi.aoc2024.dec14;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Slf4j
public class Dec14 {
    private RobotParser parser = new RobotParser();

    public int task1(String input, final int width, final int height, int seconds) {

        ArrayList<Robot> robots = parser.parseText(input);

        for (int i = 0; i < seconds; i++) {

            for (Robot robot : robots) {
                robot.moveWithinBounds(width, height);
            }
        }

        return calcSafety(robots, width, height);
    }

    public void task2(String input, final int width, final int height, int seconds) {
        ArrayList<Robot> robots = parser.parseText(input);
        HashSet<Integer> possibleTrees = new HashSet<>();

        for (int i = 0; i < seconds; i++) {
            int[][] map = new int[width][height];

            for (Robot robot : robots) {
                robot.moveWithinBounds(width, height);
                map[robot.currentX][robot.currentY] = '1';
            }
            for (int[] row : map) {
                StringBuilder rs = new StringBuilder();
                for (int c : row) {
                    if (c != 'x') {
                        rs.append((c == 0) ? ' ' : 'X');
                    }
                }
                String result = rs.toString();
                if (result.contains("XXXXXXXXXXX")) {
                    if(possibleTrees.add(i)) {
                        log.info("Seconds: {}", i +1);
                    }
                }
                if (possibleTrees.contains(i)) {
                    log.info(result);
                }
            }
        }

        log.error("Possible seconds: {}", possibleTrees.toString());
    }


    int calcSafety(List<Robot> robots, final int WIDTH, final int HEIGHT) {

        int[] quadrants = new int[4];


        int quadrantWidth = WIDTH / 2;
        int quadrantHeight = HEIGHT / 2;

        for (Robot robot : robots) {
            if (robot.currentX < quadrantWidth) {

                if (robot.currentY < quadrantHeight) {
                    quadrants[3]++;
                }
                if (robot.currentY > quadrantHeight) {
                    quadrants[2]++;
                }
            }
            if (robot.currentX > quadrantWidth) {
                if (robot.currentY < quadrantHeight) {
                    quadrants[1]++;
                }
                if (robot.currentY > quadrantHeight) {
                    quadrants[0]++;
                }
            }
        }

        return quadrants[0] * quadrants[1] * quadrants[2] * quadrants[3];
    }


}
