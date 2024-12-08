package de.tanschmi.aoc2024.dec7;

import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static de.tanschmi.aoc2024.NumberUtil.parseToLong;

@Slf4j
public class Dec7 {

    long task1(File file) throws IOException, Dec7Exception {
        String s = FileUtils.readFileToString(file, Charset.defaultCharset());
        return task1(s);
    }

    long task1(String text) throws Dec7Exception {

        List<String> lines = text.lines().toList();
        long validSum = 0;
        for (String line : lines) {
            long sum = testLine(line);
            if (sum != -1) {
                validSum += sum;
            }
        }
        return validSum;
    }

    long testLine(String line) throws Dec7Exception {
        String[] args = StringUtils.split(line, ":");
        if (args.length != 2) {
            throw new Dec7Exception("Ungültige Zeile " + line + " wurde in " + args + " gesplittet");
        }
        String testValueString = args[0];
        long testValue = parseToLong(testValueString);

        String[] operatorsStr = StringUtils.split(args[1].trim(), " ");

        List<String> calcs = collectExressions(operatorsStr);

        for (String calculation : calcs) {
            if (testCalculation(calculation, testValue)) {
                return testValue;
            }
        }
       // log.info("no valid calculation for line {}", line);
        return -1;
    }

    private boolean testCalculation(String calculation, long expected) {
        Expression expr = new ExpressionBuilder(calculation)
                .build();
        long result = Double.valueOf(expr.evaluate()).longValue();
        if (expected == result) {
            log.debug("Valid calc: {}", calculation);
            return true;
        }
        return false;
    }

    private List<String> collectExressions(String[] operatorsStr) {
        List<String> calcs = new ArrayList<>();
        calcs.add(operatorsStr[0]);

        for (int i = 1; i < operatorsStr.length; i++) {
            String current = operatorsStr[i];
            ArrayList<String> newCalcs = new ArrayList<>();
            for (String previous : calcs) {
                newCalcs.add("(" + previous + ") + " + current);
                newCalcs.add("(" + previous + ") * " + current);
            }
            calcs = newCalcs;
        }
        return calcs;
    }
}
