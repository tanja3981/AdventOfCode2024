package de.tanschmi.aoc2024.dec5;

import org.junit.jupiter.api.Test;

import java.util.*;

class OrderReaderTest {

    @Test
    void readOrder() throws Exception {
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

        Set<Integer> roots = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        OrderReader reader = new OrderReader();
        reader.readOrder(order, roots, map);


//        assertEquals(1, result.getFollowers(29).size());
//        assertEquals(1, result.getSources().size());
//        assertEquals(97, result.getSources().stream().findFirst().get());

//        assertTrue(orderList.indexOf(47) < orderList.indexOf(53));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(13));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(61));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(47));
//        assertTrue(orderList.indexOf(75) < orderList.indexOf(29));
//        assertTrue(orderList.indexOf(61) < orderList.indexOf(13));
//        assertTrue(orderList.indexOf(75) < orderList.indexOf(53));
//        assertTrue(orderList.indexOf(29) < orderList.indexOf(13));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(29));
//        assertTrue(orderList.indexOf(53) < orderList.indexOf(29));
//        assertTrue(orderList.indexOf(61) < orderList.indexOf(53));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(53));
//        assertTrue(orderList.indexOf(63) < orderList.indexOf(29));
//        assertTrue(orderList.indexOf(47) < orderList.indexOf(13));
//        assertTrue(orderList.indexOf(75) < orderList.indexOf(47));
//        assertTrue(orderList.indexOf(97) < orderList.indexOf(75));
//        assertTrue(orderList.indexOf(47) < orderList.indexOf(61));
//        assertTrue(orderList.indexOf(75) < orderList.indexOf(61));
//        assertTrue(orderList.indexOf(47) < orderList.indexOf(29));
//        assertTrue(orderList.indexOf(75) < orderList.indexOf(13));
//        assertTrue(orderList.indexOf(53) < orderList.indexOf(13));
    }
}