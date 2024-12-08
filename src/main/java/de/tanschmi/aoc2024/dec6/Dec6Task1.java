package de.tanschmi.aoc2024.dec6;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.nio.charset.Charset;

import static de.tanschmi.aoc2024.CharUtils.textToCharArray;
import static de.tanschmi.aoc2024.dec6.Direction.UP;


public class Dec6Task1 {

    public int task1(File input) throws Exception {
        String text = FileUtils.readFileToString(input, Charset.defaultCharset());
        return task1(text);
    }

    public int task1(String text) throws Exception {

        char[][] charArray = textToCharArray(text);

        Coord start = findStartPos(charArray);
        Coord c = start;
        do  {
            c = move(c, charArray);
        }
        while (c != null) ;

        return count('X', charArray);
    }

    int count(char c, char[][] array) {
        int count = 0;

        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                if(array[row][col] == c) {
                    count++;
                }
            }
        }
        return count;
    }

    Coord move(Coord start, char[][] charArray) throws Exception {
        char pos;
        Coord current;
        Coord next = start;
        do {
            current = next;
            charArray[current.row][current.col] = 'X';

            next = current.move();
            if (next.row < 0 || next.row >= charArray.length || next.col < 0 || next.col >= charArray[0].length) {
                return null;
            }
            pos = charArray[next.row][next.col];
        } while (pos != '#');

        return current.turn();
    }

    Coord findStartPos(char[][] chars) throws Exception {
        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                if (chars[row][col] == UP.value()) {
                    return new Coord(row, col, UP);
                }
            }
        }
        throw new Exception("Start position not found!");
    }
}
