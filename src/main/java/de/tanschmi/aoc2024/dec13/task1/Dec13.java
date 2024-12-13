package de.tanschmi.aoc2024.dec13.task1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Dec13 {

    public long task1(File in) throws IOException {
        InfileParser parser = new InfileParser();
        ArrayList<Claw> claws = parser.readFile(in);

        return task1(claws);
    }

    public long task1(String text) {

        InfileParser parser = new InfileParser();
        ArrayList<Claw> claws = parser.readText(text);

        return task1(claws);
    }

    long task1(ArrayList<Claw> claws) {
        int sumTokens = 0;
        for (Claw claw : claws) {
            long tokens = testClaw(claw);
            if (tokens != -1) {
                sumTokens += tokens;
            }
        }

        return sumTokens;
    }

    long testClaw(Claw claw) {

        long prizeX = claw.getPrize().getX();
        long prizeY = claw.getPrize().getY();

        ArrayList<Long> tokens = new ArrayList<>();
        long sumA = 0;
        do {
            //check X
            prizeX -= claw.getA().getX();
            sumA++;
            if (prizeX % claw.getB().getX() == 0) {
                long sumB = prizeX / claw.getB().getX();

                //check Y
                if (prizeY - (sumA * claw.getA().getY()) - (sumB * claw.getB().getY()) == 0) {
                    //match
                    tokens.add(sumA * 3 + sumB);
                }
            }

        } while (prizeX > 0 && sumA < 100);

        if (tokens.isEmpty()) {
            return -1;
        }
        return tokens.stream().mapToLong(Long::valueOf).min().getAsLong();
    }
}
