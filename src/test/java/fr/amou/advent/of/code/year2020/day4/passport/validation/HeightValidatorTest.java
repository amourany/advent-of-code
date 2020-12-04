package fr.amou.advent.of.code.year2020.day4.passport.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeightValidatorTest {

    @Test
    void it_should_return_true_for_a_valid_height_in_inches() {
        // Given
        String input = "60in";
        Passport passport = Passport.builder()
                .height(input)
                .build();

        // When
        boolean result = new HeightValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_true_for_a_valid_height_in_cm() {
        // Given
        String input = "190cm";
        Passport passport = Passport.builder()
                .height(input)
                .build();

        // When
        boolean result = new HeightValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_false_for_a_not_valid_height_in_inches() {
        // Given
        String input = "190in";
        Passport passport = Passport.builder()
                .height(input)
                .build();

        // When
        boolean result = new HeightValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute() {
        // Given
        String input = "190";
        Passport passport = Passport.builder()
                .height(input)
                .build();

        // When
        boolean result = new HeightValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }
}