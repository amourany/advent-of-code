package fr.amou.advent.of.code.year2020.days.day14;

import fr.amou.advent.of.code.year2020.Day2020;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;

public class Day14 extends Day2020 {

    public static final Pattern INSTRUCTION_PATTERN = Pattern.compile("^mem\\[([0-9]*)] = ([0-9]*)$");

    public Day14() {
        super(14);
    }

    public static void main(String[] args) throws IOException {
        new Day14().printParts();
    }

    private static String convertBase10ToBase2(Integer base10Value) {
        return StringUtils.leftPad(Integer.toBinaryString(base10Value), 36, "0");
    }

    private static Long convertBase2ToBase10(String base2Value) {
        return Long.parseLong(base2Value, 2);
    }

    private static String applyMask(String base2Value, Mask mask) {
        return IntStream.range(0, base2Value.length())
                .boxed()
                .map(index -> Optional.ofNullable(mask.getMask()
                        .get(index))
                        .orElse(String.valueOf(base2Value.charAt(index))))
                .reduce("", String::concat);
    }

    public static Map<Integer, String> applyInstructions(List<String> instructionsAndMasks) {

        Map<Integer, String> memory = new HashMap<>();

        for (String instructionsAndMask : instructionsAndMasks) {

            String[] instructionsAndMaskSplit = instructionsAndMask.split(DEFAULT_DELIMITER);
            Mask mask = new Mask(instructionsAndMaskSplit[0]);

            IntStream.range(1, instructionsAndMaskSplit.length)
                    .boxed()
                    .forEach(index -> {

                        Matcher matcher = INSTRUCTION_PATTERN.matcher(instructionsAndMaskSplit[index]);
                        matcher.find();
                        Integer memoryIndex = Integer.parseInt(matcher.group(1));
                        Integer base10Value = Integer.parseInt(matcher.group(2));

                        String base2Value = convertBase10ToBase2(base10Value);
                        memory.put(memoryIndex, applyMask(base2Value, mask));
                    });
        }

        return memory;
    }

    public static Long sumAllMemoryValues(Map<Integer, String> memory) {
        return memory.values()
                .stream()
                .map(Day14::convertBase2ToBase10)
                .reduce(0L, Math::addExact);
    }

    @Override
    public Object part1() throws IOException {
        String rawInstruction = readData();
        List<String> instructionsAndMasks = Arrays.asList(rawInstruction.split("mask = "));
        Map<Integer, String> memory = applyInstructions(instructionsAndMasks);
        return sumAllMemoryValues(memory);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
