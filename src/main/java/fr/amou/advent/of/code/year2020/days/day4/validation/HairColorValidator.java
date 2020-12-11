package fr.amou.advent.of.code.year2020.days.day4.validation;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class HairColorValidator implements Predicate<Passport> {

    private static final String HAIR_COLOR_REGEX = "#[0-9a-f]{6}";
    private static final Pattern HAIR_COLOR_PATTERN = Pattern.compile(HAIR_COLOR_REGEX);

    @Override
    public boolean test(Passport passport) {
        return HAIR_COLOR_PATTERN.matcher(passport.getHairColor())
                .find();
    }
}
