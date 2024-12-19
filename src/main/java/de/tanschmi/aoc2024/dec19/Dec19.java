package de.tanschmi.aoc2024.dec19;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec19 {
    private HashMap<String, Boolean> checked;
    private HashMap<String, Long> possibilites;

    public int task1(String availableInput, String designsInput) {
        checked = new HashMap<>();
        possibilites = new HashMap<>();

        ArrayList<String> available = new ArrayList<>(Arrays.stream(StringUtils.split(availableInput, ","))
                .map(String::trim)
                .toList());
        ArrayList<String> designs = new ArrayList<>(designsInput.lines().toList());

        String join = "(" + StringUtils.join(available, "|") + ")";
        Pattern pattern = Pattern.compile("^" + join + "(?:" + join + ")*$");

        int sumMatches = 0;
        for (String design : designs) {

            Matcher matcher = pattern.matcher(design);
            if (matcher.matches()) {
                sumMatches++;
            }

        }
        return sumMatches;
    }

    public int task1b(String availableInput, String designsInput) {
        checked = new HashMap<>();
        possibilites = new HashMap<>();

        ArrayList<String> available = new ArrayList<>(Arrays.stream(StringUtils.split(availableInput, ","))
                .map(String::trim)
                .toList());
        ArrayList<String> designs = new ArrayList<>(designsInput.lines().toList());

        int sum = 0;
        for (String design : designs) {
            if (isDesignPossible(design, available)) {
                sum++;
            }
        }
        return sum;
    }

    public long task2(String availableInput, String designsInput) {
        checked = new HashMap<>();
        possibilites = new HashMap<>();

        ArrayList<String> available = new ArrayList<>(Arrays.stream(StringUtils.split(availableInput, ","))
                .map(String::trim)
                .toList());
        ArrayList<String> designs = new ArrayList<>(designsInput.lines().toList());

        long sum = 0;
        for (String design : designs) {
            if (isDesignPossible(design, available)) {
                sum += possibleCombinations(design, available);
            }
        }
        return sum;
    }

    long possibleCombinations(String design, ArrayList<String> available) {
        if (design.isEmpty()) {
            return 1;
        }
        if (possibilites.containsKey(design)) {
            return possibilites.get(design);
        }
        long result = 0;
        for (String a : available) {
            if (design.startsWith(a)) {
                result += possibleCombinations(design.substring(a.length()), available);
            }
        }
        possibilites.put(design, result);
        return result;
    }

    boolean isDesignPossible(String design, ArrayList<String> available) {
        if (design.isEmpty()) {
            return true;
        }
        if (checked.containsKey(design)) {
            return checked.get(design);
        }
        boolean possible = false;
        for (String a : available) {
            if (design.equals(a)) {
                possible = true;
                break;
            }
            if (design.startsWith(a)) {
                if (isDesignPossible(design.substring(a.length()), available)) {
                    possible = true;
                }
            }
        }
        checked.put(design, possible);

        return possible;
    }

}
