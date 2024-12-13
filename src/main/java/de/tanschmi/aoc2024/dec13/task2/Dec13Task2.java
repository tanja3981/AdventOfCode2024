package de.tanschmi.aoc2024.dec13.task2;

import de.tanschmi.aoc2024.dec13.task1.Claw;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class Dec13Task2 {

    public long task2(File in) throws IOException {
        Task2Parser parser = new Task2Parser();
        ArrayList<Claw> claws = parser.readFile(in);

        return task2(claws);
    }

    public long task2(String text) {

        Task2Parser parser = new Task2Parser();
        ArrayList<Claw> claws = parser.readText(text);

        return task2(claws);
    }

    long task2(ArrayList<Claw> claws) {
        long sumTokens = 0;
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

        long b = calcB(prizeX, prizeY, claw.getA().getX(), claw.getA().getY(), claw.getB().getX(), claw.getB().getY());
        long a = calcA(b, prizeX, claw.getA().getX(), claw.getB().getX());

        //wenn px = a*ax + b*bx und py = a*ay + b*by wahr ist, sind keine Rundungsfehler
        if (((a * claw.getA().getX()) + (b * claw.getB().getX())) == prizeX
                && (((a * claw.getA().getY()) + (b * claw.getB().getY())) == prizeY)) {
            log.info("a={}, b={}", a, b);
            return a * 3 + b;
        } else {
            return -1;
        }
    }

    /*
     * a = (px - b*bx)/ax
     */
    private long calcA(long b, long prizeX, long aX, long bX) {
        return (prizeX - b * bX) / aX;
    }

    /*
     * b = (py*ax - ay*px) / (by*ax - ay*bx)
     */
    private long calcB(long prizeX, long prizeY, long aX, long aY, long bX, long bY) {
        return ((prizeY * aX) - (aY * prizeX)) / ((bY * aX) - (aY * bX));

    }
}
