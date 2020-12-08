package fr.amou.advent.of.code.year2020.helper.passport.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EyeColorValidatorTest {

    @Test
    void it_should_return_true_for_a_valid_attribute() {
        // Given
        String input = "brn";
        Passport passport = Passport.builder()
                .eyeColor(input)
                .build();

        // When
        boolean result = new EyeColorValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute() {
        // Given
        String input = "wat";
        Passport passport = Passport.builder()
                .eyeColor(input)
                .build();

        // When
        boolean result = new EyeColorValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }
}