package fr.amou.advent.of.code.year2020.days.day4.validation;

import java.util.List;
import java.util.function.Predicate;

public class EyeColorValidator implements Predicate<Passport> {

    private static final List<String> VALID_EYE_COLOR = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    @Override
    public boolean test(Passport passport) {
        return VALID_EYE_COLOR.contains(passport.getEyeColor());
    }
}
