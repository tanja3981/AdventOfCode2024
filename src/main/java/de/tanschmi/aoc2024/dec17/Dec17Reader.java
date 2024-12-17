package de.tanschmi.aoc2024.dec17;

import de.tanschmi.aoc2024.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class Dec17Reader {

    public ChronospatialComputer read(String input) {

        final Pattern pattern = Pattern.compile("Register A: (?<a>[0-9]*)[\r]?\\nRegister B: (?<b>[0-9]*)\r?\\nRegister C: (?<c>[0-9]*)\r?\\n\r?\\nProgram: (?<program>([0-9],)*+[0-9])");
        final Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String s_a = matcher.group("a");
            String s_b = matcher.group("b");
            String s_c = matcher.group("c");
            String program = matcher.group("program");

            String[] split = StringUtils.split(program, ',');
            ArrayList<Integer> programList = new ArrayList<>(
                    Arrays.stream(split)
                            .mapToInt(NumberUtil::parseToInt)
                            .boxed()
                            .toList());

            log.info("A: {}, B: {}, C: {}", s_a, s_b, s_c);
            log.info("Program: {}", programList);

            return ChronospatialComputer.builder()
                    .registerA(parseToInt(s_a))
                    .registerB(parseToInt(s_b))
                    .registerC(parseToInt(s_c))
                    .program(programList)
                    .build();
        } else {
            throw new RuntimeException("Fehler beim Parsen");
        }
    }
}
