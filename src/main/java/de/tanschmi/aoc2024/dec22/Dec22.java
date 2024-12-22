package de.tanschmi.aoc2024.dec22;

import java.util.ArrayList;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;
import static de.tanschmi.aoc2024.NumberUtil.parseToLong;

public class Dec22 {


    public long task1(String input, int numberSecrets) {

        ArrayList<Long> buyers = new ArrayList<>();
        input.lines().forEach(
                line -> {
                    buyers.add(parseToLong(line));
                }
        );

        for (int bIndex = 0; bIndex < buyers.size(); bIndex++) {
            long secret = buyers.get(bIndex);
            for (int i = 0; i < numberSecrets; i++) {
                secret = nextSecret(secret);
            }
            buyers.set(bIndex, secret);
        }

        return buyers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    long nextSecret(long secret) {

        long result = secret * 64;
        //mix
        secret = secret ^ result;
        //prune
        secret = secret % 16777216;

        result = secret / 32;
        //mix
        secret = secret ^ result;
        //prune
        secret = secret % 16777216;

        result = secret * 2048;
        //mix
        secret = secret ^ result;
        //prune
        secret = secret % 16777216;

        return secret;
    }
}
