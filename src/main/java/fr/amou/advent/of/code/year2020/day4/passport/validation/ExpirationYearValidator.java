package fr.amou.advent.of.code.year2020.day4.passport.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class ExpirationYearValidator implements Predicate<Passport> {

    @Override
    public boolean test(Passport passport) {
        String rawExpirationYear = passport.getExpirationYear();

        return Optional.ofNullable(rawExpirationYear)
                .map(year -> {
                    int expirationYear = Integer.parseInt(year);
                    return expirationYear >= 2020 && expirationYear <= 2030;
                })
                .orElse(false);
    }
}
