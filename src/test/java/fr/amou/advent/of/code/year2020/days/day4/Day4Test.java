package fr.amou.advent.of.code.year2020.days.day4;

import fr.amou.advent.of.code.year2020.days.day4.validation.PassportValidator;
import fr.amou.advent.of.code.year2020.days.day4.validation.RequiredAttributesValidator;
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
        long validPassports = Day4.countValidPassports(passports, new RequiredAttributesValidator());

        // Then
        assertThat(validPassports).isEqualTo(2);
    }

    @Test
    @DisplayName("Should not find any passport valid for input data")
    void part2_example1() {
        // Given
        String passport1 = "eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926";
        String passport2 = "iyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946";
        String passport3 = "hcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277";
        String passport4 = "hgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007";

        List<String> passports = List.of(passport1, passport2, passport3, passport4);

        // When
        long validPassports = Day4.countValidPassports(passports, new PassportValidator());

        // Then
        assertThat(validPassports).isZero();
    }

    @Test
    @DisplayName("Should  find 4 passports valid for input data")
    void part2_example2() {
        // Given
        String passport1 = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f";
        String passport2 = "eyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm";
        String passport3 = "hcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022";
        String passport4 = "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";

        List<String> passports = List.of(passport1, passport2, passport3, passport4);

        // When
        long validPassports = Day4.countValidPassports(passports, new PassportValidator());

        // Then
        assertThat(validPassports).isEqualTo(4);
    }
}