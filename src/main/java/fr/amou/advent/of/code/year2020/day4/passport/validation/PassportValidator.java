package fr.amou.advent.of.code.year2020.day4.passport.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PassportValidator implements Predicate<Passport> {

    private final List<Predicate<Passport>> validators;
    private final Predicate<Passport> requiredAttributesValidator = new RequiredAttributesValidator();

    public PassportValidator() {
        validators = new ArrayList<>();
        validators.add(new BirthYearValidator());
        validators.add(new IssueYearValidator());
        validators.add(new ExpirationYearValidator());
        validators.add(new HeightValidator());
        validators.add(new HairColorValidator());
        validators.add(new EyeColorValidator());
        validators.add(new PassportIdValidator());
    }

    @Override
    public boolean test(Passport passport) {
        return requiredAttributesValidator.test(passport) && validators.stream()
                .map(validator -> validator.test(passport))
                .reduce(true, Boolean::logicalAnd);
    }
}
