package fr.amou.advent.of.code.year2020.day4.passport.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class RequiredAttributesValidator implements Predicate<Passport> {

    @Override
    public boolean test(Passport passport) {
        return StringUtils.isNoneBlank(passport.getBirthYear(), passport.getIssueYear(), passport.getExpirationYear(),
                passport.getHeight(), passport.getHairColor(), passport.getEyeColor(), passport.getPassportId());
    }
}
