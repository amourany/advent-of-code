package fr.amou.advent.of.code.year2020.helper.passport.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class BirthYearValidator implements Predicate<Passport> {

    @Override
    public boolean test(Passport passport) {
        String rawBirthYear = passport.getBirthYear();

        return Optional.ofNullable(rawBirthYear)
                .map(year -> {
                    int birthYear = Integer.parseInt(year);
                    return birthYear >= 1920 && birthYear <= 2002;
                })
                .orElse(false);
    }
}
