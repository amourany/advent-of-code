package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;
import fr.amou.advent.of.code.year2020.day4.passport.validation.Passport;
import fr.amou.advent.of.code.year2020.day4.passport.validation.PassportValidator;
import fr.amou.advent.of.code.year2020.day4.passport.validation.RequiredAttributesValidator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
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

    public Day4() {
        super(4);
    }

    public static void main(String[] args) throws IOException {
        new Day4().printParts();
    }

    public static List<Passport> parsePassports(List<String> rawPassportData) {
        return rawPassportData.stream()
                .map(Day4::parsePassport)
                .collect(Collectors.toList());
    }

    private static Passport parsePassport(String rawPassportData) {
        Map<String, String> passportAttributes = Arrays.stream(rawPassportData.split(DEFAULT_DELIMITER))
                .map(dataLine -> dataLine.split(" "))
                .flatMap(Arrays::stream)
                .map(passportAttr -> passportAttr.split(":"))
                .map(passportAttr -> Map.entry(passportAttr[0], passportAttr[1]))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        return Passport.builder()
                .birthYear(passportAttributes.get(BIRTH_YEAR))
                .issueYear(passportAttributes.get(ISSUE_YEAR))
                .expirationYear(passportAttributes.get(EXPIRATION_YEAR))
                .height(passportAttributes.get(HEIGHT))
                .hairColor(passportAttributes.get(HAIR_COLOR))
                .eyeColor(passportAttributes.get(EYE_COLOR))
                .passportId(passportAttributes.get(PASSPORT_ID))
                .countryId(passportAttributes.get(COUNTRY_ID))
                .build();
    }

    public static Boolean validatePassport(Passport passport, Predicate<Passport> validator) {
        return validator.test(passport);
    }

    public static long countValidPassports(List<String> rawPassportData, Predicate<Passport> validator) {
        return rawPassportData.stream()
                .map(Day4::parsePassport)
                .map(passport -> validatePassport(passport, validator))
                .filter(valid -> valid)
                .count();
    }

    @Override
    public Object part1() throws IOException {
        List<String> rawPassportData = Arrays.stream(readData().split(DEFAULT_DELIMITER + DEFAULT_DELIMITER))
                .collect(Collectors.toList());
        return countValidPassports(rawPassportData, new RequiredAttributesValidator());
    }

    @Override
    public Object part2() throws IOException {
        List<String> rawPassportData = Arrays.stream(readData().split(DEFAULT_DELIMITER + DEFAULT_DELIMITER))
                .collect(Collectors.toList());
        return countValidPassports(rawPassportData, new PassportValidator());
    }
}
