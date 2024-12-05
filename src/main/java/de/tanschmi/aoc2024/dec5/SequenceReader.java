package de.tanschmi.aoc2024.dec5;

import de.tanschmi.aoc2024.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SequenceReader {


    List<ArrayList<Integer>> readSequences(String text) throws Exception {
        List<ArrayList<Integer>> result = new ArrayList<>();
        String[] lines = StringUtils.split(text, System.lineSeparator());
        for (String line : lines) {
            ArrayList<Integer> seq = parseSequenceLine(line);
            result.add(seq);
        }
        return result;
    }

    ArrayList<Integer> parseSequenceLine(String line) throws Exception {
        String[] parts = StringUtils.split(line, ",");
        int length = parts.length;
        if (length % 2 != 1) {
            throw new Exception("Gerade Anzahl an Argumenten, kein Mittelwert! " + line);
        }
        ArrayList<Integer> seq = new ArrayList<>();
        for (String p : parts) {
            seq.add(NumberUtil.parseToInt(p.trim()));
        }
        return seq;
    }
}
