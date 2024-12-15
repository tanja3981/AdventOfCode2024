package de.tanschmi.aoc2024.dec15;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class Dec15Test {

    @Test
    void task1_smallExample() throws IOException {
        String smallWarehouseInput = """
                ########
                #..O.O.#
                ##@.O..#
                #...O..#
                #.#.O..#
                #...O..#
                #......#
                ########""";

        String movementsInput = "<^^>>>vv<v>>v<<";

        Dec15 dec15 = new Dec15();
        int result = dec15.task1(smallWarehouseInput, movementsInput);
        assertEquals(2028, result);
    }

    @Test
    void task1_largeExample() throws IOException {
        String warehouseInput = """
                ##########
                #..O..O.O#
                #......O.#
                #.OO..O.O#
                #..O@..O.#
                #O#..O...#
                #O..O..O.#
                #.OO.O.OO#
                #....O...#
                ##########""";

        String movementsInput = """
                <vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^
                vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v
                ><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<
                <<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^
                ^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><
                ^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^
                >^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^
                <><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>
                ^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>
                v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^""";

        Dec15 dec15 = new Dec15();
        int result = dec15.task1(warehouseInput, movementsInput);
        assertEquals(10092, result);
    }

    @Test
    void task1() throws IOException {
        File warehouseFile = new File(ClassLoader.getSystemResource("inputs/dec15_warehouse.txt").getFile());
        String warehouseInput = FileUtils.readFileToString(warehouseFile, Charset.defaultCharset());

        File movementsFile = new File(ClassLoader.getSystemResource("inputs/dec15_movements.txt").getFile());
        String movementsInput = FileUtils.readFileToString(movementsFile, Charset.defaultCharset());

        Dec15 dec15 = new Dec15();
        int result = dec15.task1(warehouseInput, movementsInput);
        assertEquals(1471826, result);
    }
}