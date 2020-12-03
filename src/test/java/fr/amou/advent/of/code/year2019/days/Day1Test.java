package fr.amou.advent.of.code.year2019.days;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class Day1Test {

    @Test
    @DisplayName("For a mass of 12, the fuel required is 2")
    void part1Example1() {
        BigDecimal total = Day1.computeFuel(new BigDecimal(12));
        assertThat(total).isEqualTo(new BigDecimal(2));
    }

    @Test
    @DisplayName("For a mass of 14, the fuel required is 2")
    void part1Example2() {
        BigDecimal total = Day1.computeFuel(new BigDecimal(14));
        assertThat(total).isEqualTo(new BigDecimal(2));
    }

    @Test
    @DisplayName("For a mass of 1969, the fuel required is 654")
    void part1Example3() {
        BigDecimal total = Day1.computeFuel(new BigDecimal(1969));
        assertThat(total).isEqualTo(new BigDecimal(654));
    }

    @Test
    @DisplayName("For a mass of 100756, the fuel required is 33583")
    void part1Example4() {
        BigDecimal total = Day1.computeFuel(new BigDecimal(100756));
        assertThat(total).isEqualTo(new BigDecimal(33583));
    }

    @Test
    @DisplayName("For a mass of 12, the fuel required is 2")
    void part2Example1() {
        BigDecimal total = Day1.computeFuelMass(new BigDecimal(12));
        assertThat(total).isEqualTo(new BigDecimal(2));
    }

    @Test
    @DisplayName("For a mass of 1969, the fuel required is 966")
    void part2Example2() {
        BigDecimal total = Day1.computeFuelMass(new BigDecimal(1969));
        assertThat(total).isEqualTo(new BigDecimal(966));
    }

    @Test
    @DisplayName("For a mass of 100756, the fuel required is 50346")
    void part2Example3() {
        BigDecimal total = Day1.computeFuelMass(new BigDecimal(100756));
        assertThat(total).isEqualTo(new BigDecimal(50346));
    }
}
