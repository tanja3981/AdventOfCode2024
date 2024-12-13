package de.tanschmi.aoc2024.dec13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Claw {
    Loc a;
    Loc b;

    Loc prize;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Loc {
    int x;
    int y;
}
