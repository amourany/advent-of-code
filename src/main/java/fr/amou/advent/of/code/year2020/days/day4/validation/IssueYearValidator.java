package fr.amou.advent.of.code.year2020.days.day4.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class IssueYearValidator implements Predicate<Passport> {

    @Override
    public boolean test(Passport passport) {
        String rawIssueYear = passport.getIssueYear();

        return Optional.ofNullable(rawIssueYear)
                .map(year -> {
                    int issueYear = Integer.parseInt(year);
                    return issueYear >= 2010 && issueYear <= 2020;
                })
                .orElse(false);
    }
}
