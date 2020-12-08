package fr.amou.advent.of.code.year2020.helper.passport.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportIdValidatorTest {

    @Test
    void it_should_return_true_for_a_valid_attribute() {
        // Given
        String input = "000000001";
        Passport passport = Passport.builder()
                .passportId(input)
                .build();

        // When
        boolean result = new PassportIdValidator().test(passport);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void it_should_return_false_for_a_not_valid_attribute() {
        // Given
        String input = "0123456789";
        Passport passport = Passport.builder()
                .passportId(input)
                .build();

        // When
        boolean result = new PassportIdValidator().test(passport);

        // Then
        assertThat(result).isFalse();
    }
}