package de.tanschmi.aoc2024.dec24;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Operation {
    String operand1, operand2;
    OP op;

    public Boolean calc(Boolean o1, Boolean o2) {

        switch (op) {
            case AND:
                return o1 && o2;
            case OR:
                return o1 || o2;
            case XOR:
                return o1 ^ o2;
        }
        throw new IllegalArgumentException();
    }
}

