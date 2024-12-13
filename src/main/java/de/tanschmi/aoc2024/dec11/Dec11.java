package de.tanschmi.aoc2024.dec11;

import java.util.*;

import static de.tanschmi.aoc2024.NumberUtil.parseToLong;

/**
 * Idea from start of video https://www.youtube.com/watch?v=WJ48BFHAtPY
 *
 */
public class Dec11 {

    int task1(String input, int blinks) {

        ArrayList<Long> stones = splitStones(input);

        int count = 0;
        while (count++ < blinks) {
            blink1(stones);
        }
        return stones.size();
    }

    void blink1(List<Long> stoneRow) {
        int i = stoneRow.size() - 1;
        while (i >= 0) {
            long stone = stoneRow.get(i);
            String t = "" + stone;
            if (stone == 0) {
                stoneRow.set(i, 1L);
            } else if (t.length() % 2 == 0) {
                int half = t.length() / 2;
                stoneRow.set(i, parseToLong(t.substring(0, half)));
                stoneRow.add(i + 1, parseToLong(t.substring(half)));
            } else {
                stoneRow.set(i, stone * 2024);
            }
            i--;
        }
    }

    long task2(String input, int blinks) {
        long result = 0;
        ArrayList<Long> stoneRow = splitStones(input);
        Map<Long, Map<Integer, Long>> solved = new HashMap<>();

        for(long stone : stoneRow) {
            result += blink2(stone, blinks, solved);
        }

        return result;
    }

    long blink2(long stone, int times, Map<Long, Map<Integer, Long>> solved) {
        if (times == 0) {
            return 1;
        }
        long e = checkDictionary(solved, stone, times);
        if (e != -1) {
            return e;
        }

        String t = "" + stone;
        if (stone == 0) {
            e = blink2(1, times - 1, solved);
        } else if (t.length() % 2 == 0) {
            int half = t.length() / 2;
            long left = parseToLong(t.substring(0, half));
            long right = parseToLong(t.substring(half));
            e = blink2(left, times - 1, solved) + blink2(right, times - 1, solved);
        } else {
            e = blink2(stone * 2024, times - 1, solved);
        }
        putDictionary(solved, stone, times, e);

        return e;

    }

    void putDictionary(Map<Long, Map<Integer, Long>> solved, long stone, int times, long e) {
        solved.putIfAbsent(stone, new HashMap<>());
        solved.get(stone).put(times, e);
    }

    long checkDictionary(Map<Long, Map<Integer, Long>> solved, long stone, int times) {
        Map<Integer, Long> entry = solved.get(stone);
        if(entry != null) {
            return entry.getOrDefault(times, -1L);
        }
        return -1L;
    }

    private ArrayList<Long> splitStones(String input) {
        return new ArrayList<>( //make writable List
                Arrays.stream(input.split(" "))
                        .map(Long::parseLong).toList()
        );
    }
}
