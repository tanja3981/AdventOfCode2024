package de.tanschmi.aoc2024.dec5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SequenceReaderTest {

    @Test
    void readSequences() throws Exception {
        final String sequences = """
                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47""";
        SequenceReader reader = new SequenceReader();
        List<ArrayList<Integer>> result = reader.readSequences(sequences);
        assertNotNull(result);
        assertEquals(6, result.size());
    }
}