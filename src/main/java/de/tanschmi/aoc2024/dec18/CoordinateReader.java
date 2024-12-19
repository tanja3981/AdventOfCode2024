package de.tanschmi.aoc2024.dec18;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

public class CoordinateReader {

    public ArrayList<Coord> readCoordinates(String input) {
        return new ArrayList<>(input.lines()
                .map(line -> {
                    String[] split = StringUtils.split(line, ",");
                    Integer x = parseToInt(split[0].trim());
                    Integer y = parseToInt(split[1].trim());
                    return new Coord(y, x);
                })
                .toList()
        );
        
    }
}
