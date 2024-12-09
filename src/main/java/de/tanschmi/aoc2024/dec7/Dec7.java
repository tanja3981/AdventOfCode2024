package de.tanschmi.aoc2024.dec7;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Function;

import static de.tanschmi.aoc2024.NumberUtil.parseToLong;
import static net.objecthunter.exp4j.operator.Operator.PRECEDENCE_ADDITION;

@Slf4j
public class Dec7 {

    @SneakyThrows
    long task1(File file) throws IOException, Dec7Exception {
        String s = FileUtils.readFileToString(file, Charset.defaultCharset());
        return task1(s);
    }

    @SneakyThrows
    long task2(File file) throws IOException, Dec7Exception {
        String s = FileUtils.readFileToString(file, Charset.defaultCharset());
        return task2(s);
    }

    long task1(String text) throws Dec7Exception {

        List<String> lines = text.lines().toList();
        long validSum = 0;
        for (String line : lines) {
            long sum = testLine(line, Dec7::collectExressionsForTask1);
            if (sum != -1) {
                validSum += sum;
            }
        }
        return validSum;
    }

    long task2(String text) throws Dec7Exception {

        List<String> lines = text.lines().toList();
        long validSum = 0;
        for (String line : lines) {
            long sum = testLine(line, Dec7::collectExpressionsForTask2);
            if (sum != -1) {
                validSum += sum;
            }
        }
        return validSum;
    }

    long testLine(String line, Function<String[], List<String>> collectExpressions) throws Dec7Exception {
        String[] args = StringUtils.split(line, ":");
        if (args.length != 2) {
            throw new Dec7Exception("Ungültige Zeile " + line + " wurde in " + args + " gesplittet");
        }
        String testValueString = args[0];
        long testValue = parseToLong(testValueString);

        String[] operatorsStr = StringUtils.split(args[1].trim(), " ");

        List<String> calcs = collectExpressions.apply(operatorsStr);
        log.info("{}: Calculating {} different possibilities!", line, calcs.size());

        for (String calculation : calcs) {
            if (testCalculation(calculation, testValue)) {
                return testValue;
            }
        }
        return -1;
    }

    public boolean testCalculation(String totalCalculation, long expected) {
        String restCalc = totalCalculation.toString();

        while (restCalc.contains("||")) {
            int index = restCalc.indexOf("||");
            String left = restCalc.substring(0, index).trim();
            String right = restCalc.substring(index + 2).trim();

            boolean validLeft = false;
            int countRemovedPara = 0;
            while (!validLeft) {
                try {
                    Expression expr = new ExpressionBuilder(left)
                            //.operator(operator)
                            .build();
                    long result = Double.valueOf(expr.evaluate()).longValue();

                    restCalc = StringUtils.repeat('(', countRemovedPara) + Long.toString(result) + "" + right;
                    validLeft = true;
                } catch (IllegalArgumentException e) {
                    validLeft = false;
                    left = left.substring(1);
                    countRemovedPara++;
                }
            }
        }
        try {
            Expression expr = new ExpressionBuilder(restCalc)
                    //.operator(operator)
                    .build();
            long result = Double.valueOf(expr.evaluate()).longValue();
            if (result == expected) {
                //log.debug("Valid calc: {}", calculation);
                return true;
            }
            return false;
        } catch (EmptyStackException e) {
            throw e;
        }
    }

    public static List<String> collectExressionsForTask1(String[] operatorsStr) {
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

    public static List<String> collectExpressionsForTask2(String[] operatorsStr) {
        List<String> calcs = new ArrayList<>();
        calcs.add(operatorsStr[0]);

        for (int i = 1; i < operatorsStr.length; i++) {
            String current = operatorsStr[i];
            ArrayList<String> newCalcs = new ArrayList<>();
            for (String previous : calcs) {
                newCalcs.add("(" + previous + ") + " + current);
                newCalcs.add("(" + previous + ") * " + current);
                newCalcs.add("(" + previous + ") || " + current);
            }
            calcs = newCalcs;
        }
        return calcs;
    }
}
