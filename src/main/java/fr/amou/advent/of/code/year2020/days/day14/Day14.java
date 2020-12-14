package fr.amou.advent.of.code.year2020.days.day14;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Day14 extends Day2020 {

    public Day14() {
        super(14);
    }

    public static void main(String[] args) throws IOException {
        new Day14().printParts();
    }

    @Override
    public Object part1() throws IOException {
        String rawInstruction = readData();
        List<String> instructionsAndMasks = Arrays.asList(rawInstruction.split("mask = "));
        DecoderChip decoder = new DecoderChipV1();
        Map<? extends Number, String> memory = decoder.decode(instructionsAndMasks);
        return decoder.sumMemoryValues(memory);
    }

    @Override
    public Object part2() throws IOException {
        String rawInstruction = readData();
        List<String> instructionsAndMasks = Arrays.asList(rawInstruction.split("mask = "));
        DecoderChip decoder = new DecoderChipV2();
        Map<? extends Number, String> memory = decoder.decode(instructionsAndMasks);
        return decoder.sumMemoryValues(memory);
    }
}
