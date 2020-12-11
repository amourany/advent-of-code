package fr.amou.advent.of.code.year2020.days.day4.validation;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PassportIdValidator implements Predicate<Passport> {

    private static final String PASSPORT_ID_REGEX = "^[0-9]{9}$";
    private static final Pattern PASSPORT_ID_PATTERN = Pattern.compile(PASSPORT_ID_REGEX);

    @Override
    public boolean test(Passport passport) {
        return PASSPORT_ID_PATTERN.matcher(passport.getPassportId())
                .find();
    }
}
