package de.tanschmi.aoc2024.dec4;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class Dec4 {

    public int task1(File input) throws IOException {
        String lines = FileUtils.readFileToString(input, Charset.defaultCharset());
        return task1(lines);
    }

    public int task1(String text) {

        char[][] chars = textToCharArray(text);
        int sum = 0;
        final int rowCount = chars.length;
        final int colCount = chars[0].length;
        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[0].length; col++) {
                char c = chars[row][col];
                if (c == 'X') {

                    //left up
                    if (check(chars, 'M', row - 1, col - 1, rowCount, colCount)
                            && check(chars, 'A', row - 2, col - 2, rowCount, colCount)
                            && check(chars, 'S', row - 3, col - 3, rowCount, colCount)) {
                        sum++;
                    }
                    //up
                    if (check(chars, 'M', row - 1, col, rowCount, colCount)
                            && check(chars, 'A', row - 2, col, rowCount, colCount)
                            && check(chars, 'S', row - 3, col, rowCount, colCount)
                    ) {
                        sum++;
                    }
                    //right up
                    if (check(chars, 'M', row - 1, col + 1, rowCount, colCount)
                            && check(chars, 'A', row - 2, col + 2, rowCount, colCount)
                            && check(chars, 'S', row - 3, col + 3, rowCount, colCount)) {
                        sum++;
                    }
                    //left
                    if (check(chars, 'M', row, col - 1, rowCount, colCount)
                            && check(chars, 'A', row, col - 2, rowCount, colCount)
                            && check(chars, 'S', row, col - 3, rowCount, colCount)
                    ) {
                        sum++;
                    }
                    //right
                    if (check(chars, 'M', row, col + 1, rowCount, colCount)
                            && check(chars, 'A', row, col + 2, rowCount, colCount)
                            && check(chars, 'S', row, col + 3, rowCount, colCount)
                    ) {
                        sum++;
                    }
                    //left down
                    if (check(chars, 'M', row + 1, col - 1, rowCount, colCount)
                            && check(chars, 'A', row + 2, col-2, rowCount, colCount)
                            && check(chars, 'S', row + 3, col -3, rowCount, colCount)
                    ) {
                        sum++;
                    }
                    //down
                    if (check(chars, 'M', row + 1, col, rowCount, colCount)
                            && check(chars, 'A', row + 2, col, rowCount, colCount)
                            && check(chars, 'S', row + 3, col, rowCount, colCount)) {
                        sum++;
                    }
                    //right down
                    if (check(chars, 'M', row + 1, col + 1, rowCount, colCount)
                            && check(chars, 'A', row + 2, col + 2, rowCount, colCount)
                            && check(chars, 'S', row + 3, col + 3, rowCount, colCount)
                    ) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public int task2(File input) throws IOException {
        String lines = FileUtils.readFileToString(input, Charset.defaultCharset());
        return task2(lines);
    }

    public int task2(String text) {

        char[][] chars = textToCharArray(text);
        int sum = 0;
        final int rowCount = chars.length;
        final int colCount = chars[0].length;
        for (int row = 1; row < chars.length; row++) {
            for (int col = 1; col < chars[0].length; col++) {
                char c = chars[row][col];
                if (c == 'A') {
                    int x = 0;
                    if (check(chars, 'M', row - 1, col - 1, rowCount, colCount)
                            && check(chars, 'S', row + 1, col + 1, rowCount, colCount)) {
                        x++;
                    }
                    if (check(chars, 'M', row - 1, col + 1, rowCount, colCount)
                            && check(chars, 'S', row + 1, col - 1, rowCount, colCount)
                    ) {
                        x++;
                    }
                    if (check(chars, 'M', row + 1, col - 1, rowCount, colCount)
                            && check(chars, 'S', row - 1, col + 1, rowCount, colCount)) {
                        x++;
                    }
                    if (check(chars, 'M', row + 1, col + 1, rowCount, colCount)
                            && check(chars, 'S', row - 1, col - 1, rowCount, colCount)) {
                        x++;
                    }

                    if (x == 2) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    boolean check(final char[][] chars, char searchChar, final int row, final int col, final int rowCount, final int colCount) {

        if (row < 0 || row >= rowCount || col < 0 || col >= colCount) {
            return false;
        }

        if (chars[row][col] == searchChar) {
            return true;
        } else {
            return false;
        }
    }


    char[][] textToCharArray(String text) {
        List<String> list = text.lines().toList();

        char[][] chars = new char[list.size()][];
        int l = 0;
        for (String s : list) {
            chars[l++] = s.toCharArray();
        }
        return chars;
    }
}
