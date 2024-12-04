package de.tanschmi.aoc2024.dec3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class Dec3 {
    final String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
    final Pattern mulPattern = Pattern.compile(regex);

    final String DO = "do()";
    final String DONT = "don't()";

    public int task1(File input) throws IOException {

        List<String> lines = FileUtils.readLines(input, Charset.defaultCharset());
        int sum = 0;
        for (String line : lines) {
            sum += parseString(line);


        }
        log.info("Gesamtsumme: {}", sum);
        return sum;
    }

    public int task2(File input) throws IOException {
        String lines = FileUtils.readFileToString(input, Charset.defaultCharset());

        return parseTextWithDoAndDonts(lines);

    }

    int parseTextWithDoAndDonts(String lines) {
        ArrayList<String> instr = new ArrayList<>();

        int positionDont = findNextDont(lines);
        while (positionDont != -1) {
            String substring = lines.substring(0, positionDont);
            instr.add(substring);
            lines = lines.substring(positionDont + DONT.length());

            int positionDo = findNextDo(lines);
            if (positionDo != -1) {
                lines = lines.substring(positionDo + DO.length());
                positionDont = findNextDont(lines);
                if (positionDont == -1) {
                    instr.add(lines);
                }
            } else {

                break;
            }
        }
        int sum = 0;
        for (String part : instr) {
            sum += parseString(part);
        }

        log.info("Gesamtsumme: {}", sum);
        return sum;
    }

    int findNextDo(String lines) {
        return lines.indexOf("do()");
    }

    int findNextDont(String lines) {
        return lines.indexOf("don't()");
    }

//    int parseLineWithDoDonts(String line) {
//        int sum = parseStart(line);
//        sum += parseDoDonts(line);
//        sum += parseLast(line);
//        return sum;
//    }

//    private int parseLast(String line) {
//        Matcher dos = doPattern.matcher(line);
//        Matcher dont = dontPattern.matcher(line);
//        int lastDont = -1;
//        while (dont.find()) {
//            lastDont = dont.end();
//        }
//        int lastDo = -1;
//        while (dos.find()) {
//            lastDo = dos.end();
//        }
//        if (lastDo > lastDont) {
//            String substring = line.substring(lastDo);
//            log.debug("parseLast {}", substring);
//            return parseString(substring);
//        } else {
//            return 0;
//        }
//    }
//
//    private int parseStart(String line) {
//        Matcher donts = dontPattern.matcher(line);
//        if (donts.find()) {
//            int startMatch = donts.start();
//            String substring = line.substring(0, startMatch);
//            log.debug("parseStart {}", substring);
//            line = line.substring(startMatch);
//            return parseString(substring);
//        }
//        return 0;
//    }
//
//    private int parseDoDonts(String line) {
//        final String regex = "do\\(\\)(.*?)don't\\(\\)";
//        final Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(line);
//        int sum = matcher.results()
//                .mapToInt(matchResult -> {
//                            String m = matchResult.group(1);
//                            log.debug("parsePart {}", m);
//                            return parseString(m);
//                        }
//                )
//                .sum();
//        return sum;
//    }


    int parseString(String text) {

        Matcher m = mulPattern.matcher(text);
        return m.results()
                .peek(matchResult -> {
                    //log.debug(matchResult.group());
                })
                .mapToInt(matchResult -> {
                    return multiply(matchResult);
                })
                .sum()
                ;
    }

    int multiply(MatchResult matchResult) {
        String match = matchResult.group();
        int comma = match.indexOf(",");
        String first = match.substring(4, comma);
        String second = match.substring(comma + 1, match.length() - 1);
        int m = parseToInt(first) * parseToInt(second);
        //log.debug("{} * {} = {}", first, second, m);
        return m;
    }
}
