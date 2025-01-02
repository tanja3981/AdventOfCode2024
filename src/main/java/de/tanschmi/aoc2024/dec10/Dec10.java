package de.tanschmi.aoc2024.dec10;

import de.tanschmi.aoc2024.CharUtils;

import java.util.*;

public class Dec10 {

    long task1(String input) {

        char[][] chars = CharUtils.textToCharArray(input);

        long result = 0;
        ArrayList<Coord> starts = findStarts(chars);
        HashMap<Coord, Integer> trailheads = new HashMap<>();
        for (Coord coord : starts) {

            HashSet<Coord> tops = new HashSet<>();
            findPaths(1, coord, chars, tops);
            result += tops.size();
        }

        return result;
    }

    void findPaths(int i, Coord coord, char[][] chars, HashSet<Coord> tops) {


        ArrayList<Coord> nexts = getNext(coord);
        for (Coord next : nexts) {
            if (checkValid(next, chars)
                    && checkPath(i, next, chars)) {
                if (i == 9) {
                    tops.add(next);
                } else {
                    findPaths(i + 1, next, chars, tops);
                }
            }
        }

    }


    private boolean checkPath(int i, Coord next, char[][] chars) {
        return ("" + chars[next.row][next.col]).equals("" + i); //Why the fuck is char cast not working?
    }

    boolean checkValid(Coord next, char[][] chars) {
        return next.row >= 0 && next.row < chars.length
                && next.col >= 0 && next.col < chars[0].length;
    }


    ArrayList<Coord> getNext(Coord coord) {
        int row = coord.row;
        int col = coord.col;

        ArrayList<Coord> next = new ArrayList<>();
        next.add(new Coord(row - 1, col)); //north
        next.add(new Coord(row, col + 1));//east
        next.add(new Coord(row + 1, col));//west
        next.add(new Coord(row, col - 1));//east

        return next;
    }

    ArrayList<Coord> findStarts(char[][] chars) {
        ArrayList<Coord> starts = new ArrayList<>();

        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                if (chars[row][col] == '0') {
                    starts.add(new Coord(row, col));
                }
            }
        }
        return starts;

    }
}
