package fr.amou.advent.of.code.year2020.helper.passport.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HairColorValidatorTest {

    @Test
    void it_should_return_true_for_a_valid_attribute() {
        // Given
        String input = "#123abc";
        Passport passport = Passport.builder()
                .hairColor(input)
                .build();

        // When
        boolean result = new HairColorValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute() {
        // Given
        String input = "#123abz";
        Passport passport = Passport.builder()
                .hairColor(input)
                .build();

        // When
        boolean result = new HairColorValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute2() {
        // Given
        String input = "123abc";
        Passport passport = Passport.builder()
                .hairColor(input)
                .build();

        // When
        boolean result = new HairColorValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }
}