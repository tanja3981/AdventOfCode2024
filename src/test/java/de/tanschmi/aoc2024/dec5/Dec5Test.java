package de.tanschmi.aoc2024.dec5;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Dec5Test {

    @Test
    void task1() throws Exception {
        File order = new File(ClassLoader.getSystemResource("inputs/dec5_order.txt").getFile());
        File seq = new File(ClassLoader.getSystemResource("inputs/dec5_sequences.txt").getFile());

        Dec5 dec5 = new Dec5();
        Pair<Integer, Integer> result = dec5.task1(order, seq);
        assertEquals(4662, result.getLeft());
        assertEquals(5900, result.getRight());
    }

    @Test
    void task1_example() throws Exception {
        final String order = """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13""";
        final String sequences = """
                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47""";

        Dec5 dec5 = new Dec5();
        Pair<Integer, Integer> result = dec5.task1(order, sequences);
        assertEquals(143, result.getLeft());
        assertEquals(123, result.getRight());
    }


    @Test
    void orderSequence() throws Exception {
        final Dec5 dec5 = new Dec5();
        final String orderText = """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13""";
        Comparator<Integer> comparator = dec5.createComparator(orderText);

        List<Integer> seq1 = asList(75, 47, 61, 53, 29);
        dec5.orderSequence(seq1, comparator);
        assertEquals("[75, 47, 61, 53, 29]", seq1.toString());

        List<Integer> seq2 = asList(97, 61, 53, 29, 13);
        dec5.orderSequence(seq2, comparator);
        assertEquals("[97, 61, 53, 29, 13]", seq2.toString());

        List<Integer> seq3 = asList(75, 29, 13);
        dec5.orderSequence(seq3, comparator);
        assertEquals("[75, 29, 13]", seq3.toString());

        List<Integer> seq4 = asList(75, 97, 47, 61, 53);
        dec5.orderSequence(seq4, comparator);
        assertEquals("[97, 75, 47, 61, 53]", seq4.toString());

        List<Integer> seq5 = asList(61, 13, 29);
        dec5.orderSequence(seq5, comparator);
        assertEquals("[61, 29, 13]", seq5.toString());

        List<Integer> seq6 = asList(97, 13, 75, 29, 47);
        dec5.orderSequence(seq6, comparator);
        assertEquals("[97, 75, 47, 29, 13]", seq6.toString());
    }
}