package de.tanschmi.aoc2024.dec5;

import de.tanschmi.aoc2024.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class OrderReader {

    void readOrder(String text, Set<Integer> roots, Map<Integer, List<Integer>> map) throws Exception {

        String[] lines = StringUtils.split(text, System.lineSeparator());
        for (String line : lines) {
            parseOrderLine(line, roots, map);
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            roots.removeAll(entry.getValue());
        }
        log.info("All numbers: {}", roots);
        log.info("Order numbers: {}", map);
    }

    void parseOrderLine(String line, Set<Integer> allNos, Map<Integer, List<Integer>> map) throws Exception {
        String[] parts = StringUtils.split(line, "|");
        if (parts.length != 2) {
            throw new Exception("Komische Expression! " + line);
        }
        int left = NumberUtil.parseToInt(parts[0]);
        int right = NumberUtil.parseToInt(parts[1]);

        allNos.add(left);
        map.putIfAbsent(left, new ArrayList<>());
        map.get(left).add(right);
    }
}
