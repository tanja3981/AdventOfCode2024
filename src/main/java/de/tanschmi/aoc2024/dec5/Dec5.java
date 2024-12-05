package de.tanschmi.aoc2024.dec5;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

@Slf4j
public class Dec5 {
    public Pair<Integer, Integer> task1(File orderFile, File seqFile) throws Exception {
        String order = FileUtils.readFileToString(orderFile, Charset.defaultCharset());
        String seq = FileUtils.readFileToString(seqFile, Charset.defaultCharset());

        return task1(order, seq);
    }

    public Pair<Integer, Integer> task1(String orderText, String sequenceText) throws Exception {

        Comparator<Integer> comparator = createComparator(orderText);

        List<ArrayList<Integer>> sequences = new SequenceReader().readSequences(sequenceText);
        int sumOrdered = 0;
        int sumUnordered = 0;
        for (List<Integer> sequence : sequences) {
            List<Integer> ordered = orderSequence(sequence, comparator);
            if (sequence.equals(ordered)) {
                log.trace("equals: {}", ordered);
                int s = getMiddle(ordered);
                sumOrdered += s;
            } else {
                log.trace("not equals: {}", ordered.toString());
                int s = getMiddle(ordered);
                sumUnordered += s;
            }
        }
        return new ImmutablePair<>(sumOrdered, sumUnordered);
    }

    Comparator<Integer> createComparator(String orderText) throws Exception {
        Set<Integer> roots = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        new OrderReader().readOrder(orderText, roots, map);

        final Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (roots.contains(o1)) {
                    //muss ganz nach links
                    return -100;
                }
                if (roots.contains(o2)) {
                    //r muss ganz nach links
                    return +100;
                }
                if (map.containsKey(o1) && map.get(o1).contains(o2)) {
                    return -10;
                }
                if (map.containsKey(o2) && map.get(o2).contains(o1)) {
                    return +10;
                }
                return 0;
            }
        };
        return comparator;
    }

    List<Integer> orderSequence(List<Integer> s, Comparator<Integer> comparator) {
        ArrayList<Integer> copy = new ArrayList<>(s);
        copy.sort(comparator);
        return copy;
    }


    private int getMiddle(List<Integer> list) {
        int middleIndex = list.size() / 2;
        return list.get(middleIndex);
    }
}
