package de.tanschmi.aoc2024;

import de.tanschmi.aoc2024.dec2.Sequence;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;
import static de.tanschmi.aoc2024.NumberUtil.parseToLong;

@Slf4j
public class ListReader {

    public void readTwoColumns(File inputFile, ArrayList<Long> lefts, ArrayList<Long> rights) throws IOException {

        List<String> lines = FileUtils.readLines(inputFile, Charset.defaultCharset());
        for (String line : lines) {
            String[] s = line.split("  ");

            long left = parseToLong(s[0]);
            long right = parseToLong(s[1]);

            lefts.add(left);
            rights.add(right);
        }


    }


    public List<Sequence> readSequences(File input) throws IOException {
        List<String> lines = FileUtils.readLines(input, Charset.defaultCharset());
        List<Sequence> sequences = new ArrayList<>();
        for (String line : lines) {
            String[] s = StringUtils.split(line, " ");
            Sequence seq = new Sequence();
            for (int i = 0; i < s.length; i++) {
                int val = parseToInt(s[i]);
                seq.add(i, val);
            }
            sequences.add(seq);
        }
        return sequences;
    }
}
