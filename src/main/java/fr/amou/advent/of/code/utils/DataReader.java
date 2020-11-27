package fr.amou.advent.of.code.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DataReader {

    private DataReader() {
    }

    public static String readDataForDay(int day) throws IOException {
        String resourceName = "day" + day + ".txt";
        File resourceFile = new File(DataReader.class.getClassLoader().getResource(resourceName).getFile());
        return Files.readString(resourceFile.toPath());
    }
}
