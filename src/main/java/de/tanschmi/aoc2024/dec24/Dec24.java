package de.tanschmi.aoc2024.dec24;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class Dec24 {

    long task1(String input1, String input2) {

        HashMap<String, Boolean> values = new HashMap<>();
        parseValues(input1, values);

        HashMap<String, Operation> operations = new HashMap<>();
        parseOperations(input2, operations);

        ArrayList<String> necessary = new ArrayList<>(
                operations.keySet().stream()
                        .filter(key -> key.startsWith("z"))
                        .toList());

        while (!necessary.isEmpty()) {

            for (Map.Entry<String, Operation> entry : operations.entrySet()) {
                String key = entry.getKey();
                if (values.containsKey(key)) {
                    necessary.remove(key);
                    continue;
                }
                Operation operation = entry.getValue();
                if (values.containsKey(operation.operand1)
                        && values.containsKey(operation.operand2)) {
                    Boolean result = operation.calc(values.get(operation.operand1), values.get(operation.operand2));
                    values.put(key, result);
                    necessary.remove(key);
                }
            }

            log.info("Verbliebene OPs: {}", necessary.toString());

        }
        return calcZ(values);
    }

    long calcZ(HashMap<String, Boolean> values) {
        TreeMap<String, Boolean> sortedMap = new TreeMap<>();
        values.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("z"))
                .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        StringBuilder builder = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            builder.append(sortedMap.get(key) ? "1" : "0");
        }
        String binary = builder.reverse().toString();
        log.info("Binary: {}", binary);
        long decimalValue = Long.parseLong(binary, 2);
        log.info("Decimal: {}", decimalValue);
        return decimalValue;
    }

    void parseOperations(String input2, HashMap<String, Operation> operations) {

        input2.lines().forEach(line -> {
            String[] tokens = line.split(" -> ");
            String o = tokens[1];
            Operation op = parseOperation(tokens[0]);
            operations.put(o, op);
        });
    }

    Operation parseOperation(String s) {
        String[] split = s.split(" ");
        String o1 = split[0];
        OP op = OP.valueOf(split[1]);
        String o2 = split[2];
        return new Operation(o1, o2, op);
    }

    void parseValues(String input1, HashMap<String, Boolean> values) {

        input1.lines().forEach(line -> {
            String[] split = line.split(": ");
            values.put(split[0], split[1].equals("1"));
        });
    }
}
