package de.tanschmi.aoc2024.dec13;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class InfileParser {

    public ArrayList<Claw> readFile(File infile) throws IOException {

        List<String> lines = FileUtils.readLines(infile, Charset.defaultCharset());

        return readLines(lines);
    }
    public ArrayList<Claw> readText(String text) {
        List<String> lines = text.lines().toList();

        return readLines(lines);
    }

    ArrayList<Claw> readLines(List<String> lines) {
        ArrayList<Claw> claws = new ArrayList<>();
        for (int i = 0; i < lines.size(); i = i + 4) {
            String buttonA = lines.get(i);
            String buttonB = lines.get(i + 1);
            String prize = lines.get(i + 2);
            //empty line: lines.get(i+3)

            claws.add(parseClaw(buttonA, buttonB, prize));

        }
        return claws;
    }

    private Claw parseClaw(String buttonA, String buttonB, String prize) {

        Claw claw = new Claw();
        claw.setA(parseA(buttonA));
        claw.setB(parseB(buttonB));
        claw.setPrize(parsePrize(prize));
        return claw;
    }

    Loc parseA(String in) {
        final String prefix = "Button A: X+";
        final String separator = ", Y+";
        int iComma = in.indexOf(",");
        int iSeperator = in.indexOf(separator);
        return parseLoc(in, prefix.length(), iComma, iSeperator + separator.length());
    }

    Loc parseB(String in) {

        final String prefix = "Button B: X+";
        final String separator = ", Y+";
        int iComma = in.indexOf(",");
        int iSeperator = in.indexOf(separator);
        return parseLoc(in, prefix.length(), iComma, iSeperator + separator.length());
    }

    Loc parsePrize(String in) {
        final String prefix = "Prize: X=";
        final String separator = ", Y=";
        int iComma = in.indexOf(",");
        int iSeperator = in.indexOf(separator);
        return parseLoc(in, prefix.length(), iComma, iSeperator + separator.length());
    }

    private Loc parseLoc(String in, int indexX, int indexComma, int indexY) {
        String sx = in.substring(indexX, indexComma);
        String sy = in.substring(indexY);
        try {
            Loc loc = new Loc(
                    parseToInt(sx),
                    parseToInt(sy)
            );
            return loc;
        } catch (NumberFormatException e) {
            log.error("Fehler bei Zeile {}", in);
            throw e;
        }
    }
}
