package de.tanschmi.aoc2024.dec11;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.tanschmi.aoc2024.NumberUtil.parseToLong;

public class Dec11 {

    int task1(String input, int blinks) {

        List<String> inputList = splitStones(input);
        ArrayList<String> stones = new ArrayList<>(inputList);

        int count = 0;
        while (count++ < blinks) {
            stones = blink(stones);
        }
        return stones.size();
    }

    ArrayList<String> blink(ArrayList<String> stones) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < stones.size(); i++) {
            result.addAll(applyRule(stones.get(i)));
        }
        return result;
    }

    List<String> applyRule(String stone) {
        ArrayList<String> result = new ArrayList<>();

        Long istone = parseToLong(stone);
        if (istone == 0) {
            result.add("1");
        }
        else if (stone.length() % 2 == 0) {
            Long[] halfs = splitStone(stone);
            result.add(Long.toString(halfs[0]));
            result.add(Long.toString(halfs[1]));
        }
        else {
            long value = parseToLong(stone) * 2024;
            result.add(Long.toString(value));
        }

        return result;
    }

    Long[] splitStone(String stone) {
        int half = stone.length() / 2;
        return new Long[]{
                parseToLong(stone.substring(0, half)),
                parseToLong(stone.substring(half))
        };
    }

    private List<String> splitStones(String input) {

        String[] s = StringUtils.split(input, " ");

        return Arrays.stream(s).toList();
    }
}
