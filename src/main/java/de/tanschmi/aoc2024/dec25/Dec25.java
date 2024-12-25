package de.tanschmi.aoc2024.dec25;

import java.util.ArrayList;

public class Dec25 {

    public int task1(String input) {
        ArrayList<ArrayList<Integer>> locks = new ArrayList<>();
        ArrayList<ArrayList<Integer>> keys = new ArrayList<>();
        KeyLockParser parser = new KeyLockParser();
        parser.parse(input, locks, keys);

        int equals = 0;
        for (int l = 0; l < locks.size(); l++) {
            for (int k = keys.size() - 1; k >= 0; k--) {
                ArrayList<Integer> comb = new ArrayList<>();
                for (int i = 0; i < locks.get(l).size(); i++) {
                    int result = locks.get(l).get(i) + keys.get(k).get(i);
                    comb.add(result);
                }
                boolean allEqual = comb.stream()
                        .allMatch(value -> value < 7);
                if (allEqual) {
                    equals++;
                }
            }
        }
        return equals;
    }
}
