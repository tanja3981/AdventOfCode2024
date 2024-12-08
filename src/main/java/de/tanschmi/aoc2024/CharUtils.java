package de.tanschmi.aoc2024;

import java.util.Arrays;
import java.util.List;

public class CharUtils {

    public static char[][] textToCharArray(String text) {
        List<String> list = text.lines().toList();

        char[][] chars = new char[list.size()][];
        int l = 0;
        for (String s : list) {
            chars[l++] = s.toCharArray();
        }
        return chars;
    }

    public static String toString(char[][] chars) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                sb.append(chars[row][col]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static char[][] cloneArray(char[][] charArray) {
        char[][] newArray = new char[charArray.length][];
        for(int row = 0; row < charArray.length; row++) {
            newArray[row] = Arrays.copyOf(charArray[row], charArray[row].length);
        }
        return newArray;
    }
}
