package fr.amou.advent.of.code.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    public static final String DEFAULT_DELIMITER = System.lineSeparator();

    private DataReader() {
    }

    public static String readData(int year, int day) throws IOException {
        String resourceName = year + "/day" + day + ".txt";
        File resourceFile = new File(DataReader.class.getClassLoader()
                .getResource(resourceName)
                .getFile());
        return Files.readString(resourceFile.toPath());
    }

    public static List<Integer> readDataAsInteger(int year, int day) throws IOException {
        String rawData = readData(year, day);
        return Arrays.stream(rawData.split(DEFAULT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> readDataAsList(int year, int day) throws IOException {
        return List.of(readData(year, day).split(DEFAULT_DELIMITER));
    }
}
