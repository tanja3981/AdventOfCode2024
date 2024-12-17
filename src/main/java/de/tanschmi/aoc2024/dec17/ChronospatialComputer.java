package de.tanschmi.aoc2024.dec17;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public class ChronospatialComputer {
    Integer registerA;
    Integer registerB;
    Integer registerC;

    ArrayList<Integer> program;

    @Builder.Default
    int pointer = 0;
}
