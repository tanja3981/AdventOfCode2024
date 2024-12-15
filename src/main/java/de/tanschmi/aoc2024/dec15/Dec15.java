package de.tanschmi.aoc2024.dec15;

import de.tanschmi.aoc2024.CharUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dec15 {
    private static final char FREE = '.';
    private static final char BOX = 'O';
    private static final char ROBOT = '@';
    private static final char WALL = '#';

    private int currentRow;
    private int currentCol;
    char[][] warehouse;

    public int task1(String warehouseInput, String movementsInput) {

        warehouse = new WarehouseParser().parseWarehouse(warehouseInput);


        determineStartLocation();
        log.info(CharUtils.toString(warehouse));
        int ll = 0;
        for (String line : movementsInput.lines().toList()) {
            log.info("Movements line {}", ll);
            for (char movement : line.toCharArray()) {
                if (movement != '<' && movement != '>' && movement != 'v' && movement != '^') {
                    log.info("Skip {}", movement);
                    continue;
                }
                moveRobot(movement);
            }
        }

        return calcCoordinates();
    }

    int calcCoordinates() {
        int sum = 0;
        for (int row = 0; row < warehouse.length; row++) {
            for (int col = 0; col < warehouse[row].length; col++) {
                if (warehouse[row][col] == BOX) {
                    sum += (100 * row) + col;
                }
            }
        }
        return sum;
    }

    private void determineStartLocation() {

        for (int row = 1; row < warehouse.length; row++) {
            for (int col = 1; col < warehouse[row].length; col++) {

                if (warehouse[row][col] == '@') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
        log.info("Start location is {}/{}", currentRow, currentCol);
    }

    private void moveRobot(char movement) {
        log.info("Move '{}'", movement);
        switch (movement) {
            case '<': //left
                left();
                break;
            case '^':
                up();
                break;
            case '>':
                right();
                break;
            case 'v':
                down();
                break;
            default:
                log.error("Unknown movement: '{}'", movement);
                break;
        }
        log.info(CharUtils.toString(warehouse));
    }

    void right() {
        int nextCol = currentCol + 1;

        if (warehouse[currentRow][nextCol] == WALL) {
            //do nothing
            return;
        } else if (warehouse[currentRow][nextCol] == FREE) {
            warehouse[currentRow][currentCol] = FREE;
            currentCol = nextCol;
            warehouse[currentRow][currentCol] = ROBOT;
        } else if (warehouse[currentRow][nextCol] == BOX) {
            int nextBoxCol = nextCol + 1;
            while (nextBoxCol < warehouse[currentRow].length) {
                if (warehouse[currentRow][nextBoxCol] == FREE) {
                    //shift box
                    warehouse[currentRow][nextBoxCol] = BOX;
                    //move robot
                    warehouse[currentRow][currentCol] = FREE;
                    currentCol = nextCol;
                    warehouse[currentRow][currentCol] = ROBOT;
                    break;
                } else if (warehouse[currentRow][nextBoxCol] == WALL) {
                    break;
                } else {
                    nextBoxCol++;
                }
            }
        }
    }

    void left() {
        int nextCol = currentCol - 1;

        if (warehouse[currentRow][nextCol] == WALL) {
            //do nothing
        } else if (warehouse[currentRow][nextCol] == FREE) {
            warehouse[currentRow][currentCol] = FREE;
            currentCol = nextCol;
            warehouse[currentRow][currentCol] = ROBOT;
        } else if (warehouse[currentRow][nextCol] == BOX) {
            int nextBoxCol = nextCol - 1;
            while (nextBoxCol >= 0) {
                if (warehouse[currentRow][nextBoxCol] == FREE) {
                    //shift box
                    warehouse[currentRow][nextBoxCol] = BOX;
                    //move robot
                    warehouse[currentRow][currentCol] = FREE;
                    currentCol = nextCol;
                    warehouse[currentRow][currentCol] = ROBOT;
                    break;
                } else if (warehouse[currentRow][nextBoxCol] == WALL) {
                    break;
                } else {
                    nextBoxCol--;
                }
            }
        }
    }


    void up() {
        int nextRow = currentRow - 1;

        if (warehouse[nextRow][currentCol] == WALL) {
            //do nothing
        } else if (warehouse[nextRow][currentCol] == FREE) {
            warehouse[currentRow][currentCol] = FREE;
            currentRow = nextRow;
            warehouse[currentRow][currentCol] = ROBOT;
        } else if (warehouse[nextRow][currentCol] == BOX) {
            int nextBoxRow = nextRow - 1;
            while (nextBoxRow >= 0) {
                if (warehouse[nextBoxRow][currentCol] == FREE) {
                    //shift box
                    warehouse[nextBoxRow][currentCol] = BOX;
                    //move robot
                    warehouse[currentRow][currentCol] = FREE;
                    currentRow = nextRow;
                    warehouse[currentRow][currentCol] = ROBOT;
                    break;
                } else if (warehouse[nextBoxRow][currentCol] == WALL) {
                    break;
                } else {
                    nextBoxRow--;
                }
            }
        }
    }


    void down() {
        int nextRow = currentRow + 1;

        if (warehouse[nextRow][currentCol] == WALL) {
            //do nothing
        } else if (warehouse[nextRow][currentCol] == FREE) {
            warehouse[currentRow][currentCol] = FREE;
            currentRow = nextRow;
            warehouse[currentRow][currentCol] = ROBOT;
        } else if (warehouse[nextRow][currentCol] == BOX) {
            int nextBoxRow = nextRow + 1;
            while (nextBoxRow < warehouse.length) {
                if (warehouse[nextBoxRow][currentCol] == FREE) {
                    //shift box
                    warehouse[nextBoxRow][currentCol] = BOX;
                    //move robot
                    warehouse[currentRow][currentCol] = FREE;
                    currentRow = nextRow;
                    warehouse[currentRow][currentCol] = ROBOT;
                    break;
                } else if (warehouse[nextBoxRow][currentCol] == WALL) {
                    break;
                } else {
                    nextBoxRow++;
                }
            }
        }
    }

}
