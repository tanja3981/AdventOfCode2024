package de.tanschmi.aoc2024;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberUtil {


    public static long parseToLong(String s) {
        try {
            return Long.parseLong(s.trim());
        } catch (NumberFormatException e) {
            log.error("Fehler bei Wert {}", s);
            throw e;
        }
    }

    public static int parseToInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            log.error("Fehler bei Wert {}", s);
            throw e;
        }
    }
}
