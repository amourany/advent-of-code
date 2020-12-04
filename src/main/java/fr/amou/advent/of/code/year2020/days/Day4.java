package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;

public class Day4 extends Day2020 {

    private static final String BIRTH_YEAR = "byr";
    private static final String ISSUE_YEAR = "iyr";
    private static final String EXPIRATION_YEAR = "eyr";
    private static final String HEIGHT = "hgt";
    private static final String HAIR_COLOR = "hcl";
    private static final String EYE_COLOR = "ecl";
    private static final String PASSPORT_ID = "pid";
    private static final String COUNTRY_ID = "cid";
    private static final List<String> REQUIRED_ATTRIBUTES = List.of(
            BIRTH_YEAR, ISSUE_YEAR, EXPIRATION_YEAR, HEIGHT, HAIR_COLOR, EYE_COLOR, PASSPORT_ID);

    public Day4() {
        super(4);
    }

    public static void main(String[] args) throws IOException {
        new Day4().printParts();
    }

    public static List<Map<String, String>> parsePassports(List<String> rawPassportData) {
        return rawPassportData.stream()
                .map(Day4::parsePassport)
                .collect(Collectors.toList());
    }

    private static Map<String, String> parsePassport(String rawPassportData) {
        return Arrays.stream(rawPassportData.split(DEFAULT_DELIMITER))
                .map(dataLine -> dataLine.split(" "))
                .flatMap(Arrays::stream)
                .map(passportAttr -> passportAttr.split(":"))
                .map(passportAttr -> Map.entry(passportAttr[0], passportAttr[1]))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Boolean validatePassport(Map<String, String> passport) {
        return passport.keySet()
                .containsAll(REQUIRED_ATTRIBUTES);
    }

    public static long countValidPassports(List<String> rawPassportData) {
        return rawPassportData.stream()
                .map(Day4::parsePassport)
                .map(Day4::validatePassport)
                .filter(valid -> valid)
                .count();
    }

    @Override
    public Object part1() throws IOException {
        List<String> rawPassportData = Arrays.stream(readData().split(DEFAULT_DELIMITER + DEFAULT_DELIMITER))
                .collect(Collectors.toList());
        return countValidPassports(rawPassportData);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
