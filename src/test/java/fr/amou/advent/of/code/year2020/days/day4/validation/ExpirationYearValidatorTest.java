package fr.amou.advent.of.code.year2020.days.day4.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpirationYearValidatorTest {

    @Test
    void it_should_return_true_for_a_valid_attribute() {
        // Given
        String input = "2021";
        Passport passport = Passport.builder()
                .expirationYear(input)
                .build();

        // When
        boolean result = new ExpirationYearValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute() {
        // Given
        String input = "2031";
        Passport passport = Passport.builder()
                .expirationYear(input)
                .build();

        // When
        boolean result = new ExpirationYearValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }
}