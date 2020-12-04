package fr.amou.advent.of.code.year2020.day4.passport.validation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passport {

    private String birthYear;
    private String issueYear;
    private String expirationYear;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;
}
