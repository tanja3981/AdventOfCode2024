package de.tanschmi.aoc2024.dec19;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec19 {

    public int task1(String availableInput, String designsInput) {

        ArrayList<String> available = new ArrayList<>(Arrays.stream(StringUtils.split(availableInput, ","))
                .map(String::trim)
                .toList());
        ArrayList<String> designs = new ArrayList<>(designsInput.lines().toList());

        String join = "(" + StringUtils.join(available, "|") + ")";
        Pattern pattern = Pattern.compile("^" + join + "(?:" + join + ")*");

        int sumMatches = 0;
        for (String design : designs) {

            Matcher matcher = pattern.matcher(design);
            if (matcher.matches()) {
                sumMatches++;
            }

        }
        return sumMatches;
    }

}
