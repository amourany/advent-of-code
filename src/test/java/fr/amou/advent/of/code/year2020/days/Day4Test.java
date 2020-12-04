package fr.amou.advent.of.code.year2020.days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    @Test
    @DisplayName("Should find 2 valid passports with example input data")
    void part1_example1() {
        // Given
        String passport1 = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm";
        String passport2 = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\ncl:#cfa07d byr:1929";
        String passport3 = "hcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm";
        String passport4 = "hcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in";

        List<String> passports = List.of(passport1, passport2, passport3, passport4);

        // When
        long validPassports = Day4.countValidPassports(passports);

        // Then
        assertThat(validPassports).isEqualTo(2);
    }
}