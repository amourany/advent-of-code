package fr.amou.advent.of.code.year2020.helper.passport.validation;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightValidator implements Predicate<Passport> {

    private static final String CM_UNIT = "cm";
    private static final String IN_UNIT = "in";

    private static final String HEIGHT_REGEX = "([0-9]*)(cm|in)";
    private static final Pattern HEIGHT_PATTERN = Pattern.compile(HEIGHT_REGEX);

    @Override
    public boolean test(Passport passport) {
        Matcher heightMatcher = HEIGHT_PATTERN.matcher(passport.getHeight());

        if (heightMatcher.find()) {
            String height = heightMatcher.group(1);
            String unit = heightMatcher.group(2);
            int parsedHeight = Integer.parseInt(height);

            if (unit.equals(CM_UNIT)) {
                return parsedHeight >= 150 && parsedHeight <= 193;
            } else if (unit.equals(IN_UNIT)) {
                return parsedHeight >= 59 && parsedHeight <= 76;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
