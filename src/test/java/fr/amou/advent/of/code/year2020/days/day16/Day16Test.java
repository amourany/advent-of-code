package fr.amou.advent.of.code.year2020.days.day16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day16Test {

    @Test
    void part1_example1() {
        // Given
        String notes = "class: 1-3 or 5-7\nrow: 6-11 or 33-44\nseat: 13-40 or 45-50\n\nyour ticket:\n7,1,14\n\nnearby tickets:\n7,3,47\n40,4,50\n55,2,20\n38,6,12\n";

        // When
        Integer result = Day16.computeTicketScanningErrorRate(notes);

        // Then
        assertThat(result).isEqualTo(71);
    }
}