package de.tanschmi.aoc2024.dec12;

import de.tanschmi.aoc2024.CharUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

public class Dec12 {

    public long task1(String input) {

        char[][] chars = CharUtils.textToCharArray(input);

        long price = 0;
        HashSet<Coord> done = new HashSet<>();
        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                Coord current = new Coord(row, col);
                if (done.contains(current)) {
                    continue;
                }
                ArrayList<Coord> field = new ArrayList<>();

                char c = chars[row][col];
                AtomicLong perimeter = new AtomicLong();
                searchField(chars, current, done, field, c, perimeter);


                price += perimeter.get() * field.size();
            }
        }

        return price;

    }

    private boolean searchField(char[][] chars, Coord current, HashSet<Coord> done, ArrayList<Coord> field, char c, AtomicLong perimeter) {


        if (current.row >= 0 && current.row < chars.length
                && current.col >= 0 && current.col < chars[current.row].length) {

            if (chars[current.row][current.col] == c) {

                if (done.contains(current)) {
                    return true;
                }
                done.add(current);
                field.add(current);

                if (!searchField(chars, new Coord(current.row - 1, current.col), done, field, c, perimeter)) {
                    perimeter.addAndGet(1);
                }
                if (!searchField(chars, new Coord(current.row, current.col + 1), done, field, c, perimeter)) {
                    perimeter.addAndGet(1);
                }
                if (!searchField(chars, new Coord(current.row + 1, current.col), done, field, c, perimeter)) {
                    perimeter.addAndGet(1);
                }
                if (!searchField(chars, new Coord(current.row, current.col - 1), done, field, c, perimeter)) {
                    perimeter.addAndGet(1);
                }
                return true;

            }
        }
        return false;
    }
}
