package de.tanschmi.aoc2024.dec14;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class RobotParser {

    ArrayList<Robot> parseText(String lines) {
        ArrayList<Robot> robots = new ArrayList<>();

        lines.lines()
                .forEach(line -> robots.add(getRobot(line)));

        return robots;
    }

    Robot getRobot(String line) {
        final String regex = "^p=([\\d]+),([\\d]+)\\sv=([+-]?[\\d]+),([+-]?[\\d]+)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {

            String initX = matcher.group(1);
            String initY = matcher.group(2);
            String veloX = matcher.group(3);
            String veloY = matcher.group(4);

            return new Robot(parseToInt(initX),
                    parseToInt(initY),
                    parseToInt(veloX),
                    parseToInt(veloY)
            );
        } else {
            log.error("No match: {}", line);
        }
        throw new Dec14Exception("Cannot parse line: " + line);

    }
}
