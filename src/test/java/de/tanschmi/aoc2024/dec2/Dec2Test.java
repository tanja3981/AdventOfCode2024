package de.tanschmi.aoc2024.dec2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Dec2Test {
    private final Dec2 task = new Dec2();

    @Test
    void task1() throws IOException {
        final int expected = 432;
        File f = new File(ClassLoader.getSystemResource("inputs/dec2.txt").getFile());

        assertEquals(expected, task.step1(f));
    }

    @Test
    void task2() throws IOException {
        final int expected = 488;
        File f = new File(ClassLoader.getSystemResource("inputs/dec2.txt").getFile());
        assertEquals(expected, task.step2(f));
    }

    @Test
    void isSequenceSafe_incr() {
        ArrayList<Integer> list = createList(1, 2, 3, 6);

        Dec2 task = new Dec2();
        assertEquals(true, task.isSequenceSafe(list));
    }

    @Test
    void isSequenceSafe_decr() {
        ArrayList<Integer> list = createList(6, 3, 2, 1);


        Dec2 task = new Dec2();
        assertEquals(true, task.isSequenceSafe(list));
    }


    @Test
    void isSequenceSafe_unsafeOrder() {
        ArrayList<Integer> list = createList(6, 3, 2, 3);

        Dec2 task = new Dec2();
        assertEquals(false, task.isSequenceSafe(list));
    }

    @Test
    void isSequenceSafe_unsafeDiff() {
        ArrayList<Integer> list = createList(11, 7, 3, 2);

        Dec2 task = new Dec2();
        assertEquals(false, task.isSequenceSafe(list));
    }

    private ArrayList<Integer> createList(int i1, int i2, int i3, int i4) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        return list;
    }

    @Test
    void step2_test1() {
        ArrayList<Integer> list = asList(new Integer[]{7, 6, 4, 2, 1});

        assertEquals(true, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(true, task.areSubsequencesSafe(sequence));
    }

    @Test
    void step2_test2() {
        ArrayList<Integer> list = asList(new Integer[]{1, 2, 7, 8, 9});
        assertEquals(false, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(false, task.areSubsequencesSafe(sequence));
    }

    @Test
    void step2_test3() {
        ArrayList<Integer> list = asList(new Integer[]{9, 7, 6, 2, 1});
        assertEquals(false, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(false, task.areSubsequencesSafe(sequence));
    }

    @Test
    void step2_test4() {

        ArrayList<Integer> list = asList(new Integer[]{1, 3, 2, 4, 5});
        assertEquals(false, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(true, task.areSubsequencesSafe(sequence));
    }

    @Test
    void step2_test5() {

        ArrayList<Integer> list = asList(new Integer[]{8, 6, 4, 4, 1});
        assertEquals(false, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(true, task.areSubsequencesSafe(sequence));
    }

    @Test
    void step2_test6() {

        ArrayList<Integer> list = asList(new Integer[]{1, 3, 6, 7, 9});
        assertEquals(true, task.isSequenceSafe(list));
        Sequence sequence = new Sequence(list);
        assertEquals(true, task.areSubsequencesSafe(sequence));
    }

    ArrayList<Integer> asList(Integer[] a) {

        ArrayList<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(a));
        return list;
    }
}