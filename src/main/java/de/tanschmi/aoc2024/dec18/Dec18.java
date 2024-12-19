package de.tanschmi.aoc2024.dec18;

import de.tanschmi.aoc2024.CharUtils;
import de.tanschmi.aoc2024.dec16.Direction;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Dec18 {
    public static final char CORRUPTED = '#';

    static final ArrayList<Integer> allDirections = new ArrayList<>(Arrays.asList(Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH));

    long task1(String input, int range, int steps) {

        ArrayList<Coord> coords = new CoordinateReader().readCoordinates(input);

        char[][] mem = new char[range][range];
        //initialize
        for (char[] chars : mem) {
            Arrays.fill(chars, '.');
        }

        //put in corrupted
        for (int step = 0; step < steps; step++) {
            Coord c = coords.get(step);
            mem[c.row][c.col] = CORRUPTED;
        }
        log.debug("Memory after {} steps: {}", steps, CharUtils.toString(mem));

        long result = findStepsThroughMemory(mem);
        log.debug("Result: {}", result);

        return result;
    }

    Coord task2(String input, int range, int stepsStart) {
        ArrayList<Coord> coords = new CoordinateReader().readCoordinates(input);

        char[][] mem = new char[range][range];
        //initialize
        for (char[] chars : mem) {
            Arrays.fill(chars, '.');
        }
        for (int step = 0; step < stepsStart; step++) {
            Coord c = coords.get(step);
            mem[c.row][c.col] = CORRUPTED;
        }
        //log.info("Memory after {} steps: \n{}", stepsStart, CharUtils.toString(mem));

        for (int noSteps = stepsStart; noSteps < coords.size(); noSteps++) {

            Coord c = coords.get(noSteps);
            mem[c.row][c.col] = CORRUPTED;

            long result = findStepsThroughMemory(mem);
            if (result == -1) {
                //log.info("Memory after {} steps: \n{}", noSteps, CharUtils.toString(mem));
                return c;
            }
        }
        return null;
    }

    long findStepsThroughMemory(char[][] maze) {
        List<State> reached = new ArrayList<>();


        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int startRow = 0, startCol = 0;
        int endRow = maze.length - 1, endCol = maze[0].length - 1;

        Queue<State> nextPos = new LinkedList<>();
        nextPos.offer(new State(startRow, startCol, null));

        while (!nextPos.isEmpty()) {
            State currentStep = nextPos.poll();
            log.debug("Step {}", currentStep);

            int row = currentStep.row, col = currentStep.col;//, direction = currentStep.direction;
            if (row == endRow && col == endCol) {
                reached.add(currentStep);
                continue;
            }
            if (visited[row][col] /*== true*/) {
                continue;
            }
            visited[row][col] = true;

            for (Integer allDirection : allDirections) { //alle Richtungen außer Kehrtwende
                int newRow = row, newCol = col, newDirection = allDirection;

                if (newDirection == Direction.NORTH) {//oben
                    newRow = row - 1;
                    newCol = col;
                } else if (newDirection == Direction.SOUTH) {//unten
                    newRow = row + 1;
                    newCol = col;
                } else if (newDirection == Direction.WEST) {//links
                    newRow = row;
                    newCol = col - 1;
                } else if (newDirection == Direction.EAST) {//rechts
                    newRow = row;
                    newCol = col + 1;
                }
                State newStep = new State(newRow, newCol, currentStep);

                if (checkValidRow(newRow, maze.length)
                        && checkValidCol(newCol, maze[newRow].length)
                        && checkValidPos(maze, newRow, newCol)
                        && !visited[newRow][newCol]) {

                    nextPos.offer(newStep);
                }
            }
        }

        if (!reached.isEmpty()) {
            return reached.stream()
                    .mapToLong(state -> {
                        long steps = 0;
                        while (state.previous != null) {
                            steps++;
                            state = state.previous;
                        }
                        return steps;
                    })
                    .min().getAsLong();
        } else {
            return -1;
        }
    }

    boolean checkValidRow(int row, int rows) {
        return row >= 0 && row < rows;
    }

    boolean checkValidCol(int col, int cols) {
        return col >= 0 && col < cols;
    }

    boolean checkValidPos(char[][] maze, int row, int col) {
        return maze[row][col] == '.';
    }
}
