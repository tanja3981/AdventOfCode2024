package de.tanschmi.aoc2024.dec15;

import java.util.List;

public class WarehouseParser {

    public char[][] parseWarehouse(String input) {

        List<String> lines = input.lines().toList();
        char[][] warehouse = new char[lines.size()][];

        int rowNo = 0;
        for (String line : lines) {
            if (line.isEmpty()) break;

            char[] chars = line.toCharArray();
            warehouse[rowNo++] = chars;
        }

        return warehouse;
    }
}
