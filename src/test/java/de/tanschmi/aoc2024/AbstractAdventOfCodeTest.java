package de.tanschmi.aoc2024;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class AbstractAdventOfCodeTest {

    public static File loadInputFile(String name) {
        return new File(ClassLoader.getSystemResource(name).getFile());
    }

    public static String loadInput(String s) throws IOException {
        File inFile = loadInputFile(s);
        return FileUtils.readFileToString(inFile, Charset.defaultCharset());
    }

    //public abstract void task1() throws IOException;
    //public abstract void task2() throws IOException;
}
