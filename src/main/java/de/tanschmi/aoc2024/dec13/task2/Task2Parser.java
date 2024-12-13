package de.tanschmi.aoc2024.dec13.task2;

import de.tanschmi.aoc2024.dec13.task1.InfileParser;
import de.tanschmi.aoc2024.dec13.task1.Loc;
import lombok.extern.slf4j.Slf4j;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class Task2Parser extends InfileParser {
    private static final long OFFSET = 10000000000000L;

    protected Loc parsePrize(String in) {
        final String prefix = "Prize: X=";
        final String separator = ", Y=";
        int iComma = in.indexOf(",");
        int iSeperator = in.indexOf(separator);
        return parseLocWithOffset(in, prefix.length(), iComma, iSeperator + separator.length());
    }

    protected Loc parseLocWithOffset(String in, int indexX, int indexComma, int indexY) {
        String sx = in.substring(indexX, indexComma);
        String sy = in.substring(indexY);
        try {
            Loc loc = new Loc(
                    parseToInt(sx) + OFFSET,
                    parseToInt(sy) + OFFSET
            );
            return loc;
        } catch (NumberFormatException e) {
            log.error("Fehler bei Zeile {}", in);
            throw e;
        }
    }
}
