package de.tanschmi.aoc2024.dec25;

import java.util.ArrayList;

public class KeyLockParser {

    void parse(String input, ArrayList<ArrayList<Integer>> locks, ArrayList<ArrayList<Integer>> keys) {


        String[] splits = input.split(System.lineSeparator());

        for (int i = 0; i < splits.length; i = i + 8) {

            String header = splits[i];
            if (header.equals("#####")) {
                //treat as lock
                locks.add(
                        parseLock(
                                new String[]{splits[i + 1], splits[i + 2], splits[i + 3], splits[i + 4], splits[i + 5], splits[i + 6]}
                        )
                );
            } else if (header.equals(".....")) {
                keys.add(
                        parseLock(new String[]{
                                splits[i + 6], splits[i + 5], splits[i + 4], splits[i + 3], splits[i + 2], splits[i + 1]
                        })
                );
            } else {
                throw new RuntimeException("Komischer Input");
            }

            //String blank = splits[i + 7]; //ignore
        }




    }

    ArrayList<Integer> parseLock(String[] lines) {
        ArrayList<Integer> lock = new ArrayList<>();
        //init
        for (int i = 0; i < lines[0].length(); i++) {
            lock.add(0);
        }
        //parse
        for (String line : lines) {

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    int value = lock.get(i);
                    lock.set(i, ++value);
                }
            }
        }
        return lock;
    }
}
