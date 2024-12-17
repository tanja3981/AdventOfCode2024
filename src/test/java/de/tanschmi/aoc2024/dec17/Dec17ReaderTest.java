package de.tanschmi.aoc2024.dec17;

import org.junit.jupiter.api.Test;

class Dec17ReaderTest {

    @Test
    void read() {
        final String input = """
                Register A: 47792830
                Register B: 0
                Register C: 0
                
                Program: 2,4,1,5,7,5,1,6,4,3,5,5,0,3,3,0""";

        Dec17Reader reader = new Dec17Reader();
        reader.read(input);

    }
}