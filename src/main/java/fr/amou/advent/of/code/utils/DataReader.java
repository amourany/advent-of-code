package fr.amou.advent.of.code.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private DataReader() {
    }

    public static String readDataForDay(int day) throws IOException {
        String resourceName = "day" + day + ".txt";
        File resourceFile = new File(DataReader.class.getClassLoader()
                .getResource(resourceName)
                .getFile());
        return Files.readString(resourceFile.toPath());
    }

    public static List<Integer> readDataAsIntegerForDay(int day) throws IOException {
        String rawData = readDataForDay(day);
        return Arrays.stream(rawData.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> readDataAsListForDay(int day) throws IOException {
        return List.of(readDataForDay(day).split("\n"));
    }
}
