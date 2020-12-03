package fr.amou.advent.of.code.common;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@Log4j2
public abstract class Day {

    protected final int year;
    protected final int day;

    public Day(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public abstract Object part1() throws IOException;

    public abstract Object part2() throws IOException;

    public void printParts() throws IOException {
        log.info("  Part 1 : {}", part1());
        log.info("  Part 2 : {}", part2());
        log.info("\n");
    }

    public String readData() throws IOException {
        return DataReader.readData(year, day);
    }

    public List<Integer> readDataAsInteger() throws IOException {
        return DataReader.readDataAsInteger(year, day);
    }

    public List<String> readDataAsList() throws IOException {
        return DataReader.readDataAsList(year, day);
    }
}