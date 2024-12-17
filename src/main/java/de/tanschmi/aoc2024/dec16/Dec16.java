package de.tanschmi.aoc2024.dec16;

import de.tanschmi.aoc2024.dec15.WarehouseParser;

import java.util.*;

public class Dec16 {
    static final ArrayList<Integer> allDirections = new ArrayList<>(Arrays.asList(Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH));

    public int task(Task task, String input) {

        //use same parser as for warehouse on Dec15
        char[][] maze = new WarehouseParser().parseWarehouse(input);

        // Finde Start- und Endpunkt
        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 'S') {
                    startRow = row;
                    startCol = col;
                }
                if (maze[row][col] == 'E') {
                    endRow = row;
                    endCol = col;
                }
            }
        }

        boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
        PriorityQueue<State> nextPos = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        nextPos.offer(new State(startRow, startCol, 0, Direction.EAST, null));

        int shortestDistance = Integer.MAX_VALUE;
        ArrayList<State> endStates = new ArrayList<>();
        while (!nextPos.isEmpty()) {
            //visualizeMaze(maze, visited);
            State currentStep = nextPos.poll();

            int row = currentStep.row, col = currentStep.col, distance = currentStep.cost, direction = currentStep.direction;
            if (row == endRow && col == endCol) {
                //visualizeMaze(maze, visited);
                shortestDistance = Math.min(shortestDistance, distance);
                endStates.add(currentStep);
                continue;
            }
            if (visited[row][col][direction] /*== true*/) {
                continue;
            }
            visited[row][col][direction] = true;

            ArrayList<Integer> possibleDirs = new ArrayList(allDirections);
            switch (direction) {
                case Direction.NORTH:
                    possibleDirs.remove(Direction.SOUTH);
                    break;
                case Direction.EAST:
                    possibleDirs.remove(Direction.WEST);
                    break;
                case Direction.SOUTH:
                    possibleDirs.remove(Direction.NORTH);
                    break;
                case Direction.WEST:
                    possibleDirs.remove(Direction.EAST);
                    break;
            }

            for (int i = 0; i < possibleDirs.size(); i++) { //alle Richtungen außer Kehrtwende
                int newRow = row, newCol = col, newDirection = possibleDirs.get(i);

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


                if (checkValidRow(newRow, maze.length)
                        && checkValidCol(newCol, maze[newRow].length)
                        && checkValidPos(maze, newRow, newCol)
                        && !visited[newRow][newCol][newDirection]) {
                    int newCost;
                    if (newDirection != direction) {
                        newCost = distance + 1001;
                    } else {
                        newCost = distance + 1;
                    }
                    nextPos.offer(new State(newRow, newCol, newCost, newDirection, currentStep));
                }
            }
        }


        if (task == Task.TASK1) {
            return shortestDistance;
        } else {
            HashSet<int[]> path = new HashSet<>();
            for(State endState : endStates) {

                while (endState != null) {
                    path.add(new int[]{endState.row, endState.col});
                    endState = endState.previous;
                }
               // minTiles = Math.min(minTiles, path.size());
            }
            return path.size();
        }
    }

    private void visualizeMaze(char[][] maze, boolean[][][] visited) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (visited[row][col][Direction.NORTH]) {
                    builder.append('0');
                } else if (visited[row][col][Direction.EAST]) {
                    builder.append('0');
                } else if (visited[row][col][Direction.WEST]) {
                    builder.append('0');
                } else if (visited[row][col][Direction.SOUTH]) {
                    builder.append('0');
                } else {
                    builder.append(maze[row][col]);
                }
            }
            builder.append('\n');
        }
        System.out.println(builder.toString());

    }

    boolean checkValidRow(int row, int rows) {
        return row >= 0 && row < rows;
    }

    boolean checkValidCol(int col, int cols) {
        return col >= 0 && col < cols;
    }

    boolean checkValidPos(char[][] maze, int row, int col) {
        return maze[row][col] == '.' || maze[row][col] == 'E' || maze[row][col] == 'S';
    }
}
