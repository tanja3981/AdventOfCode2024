package de.tanschmi.aoc2024.dec25;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class KeyLockParserTest {

    @Test
    void parse() throws IOException {
        File file = new File(ClassLoader.getSystemResource("inputs/dec25.txt").getFile());
        String input = FileUtils.readFileToString(file, Charset.defaultCharset());

        ArrayList<ArrayList<Integer>> locks = new ArrayList<>();
        ArrayList<ArrayList<Integer>> keys = new ArrayList<>();

        KeyLockParser parser = new KeyLockParser();
        parser.parse(input, locks, keys);

        assertEquals(250, locks.size());
        assertEquals(250, keys.size());
    }
}