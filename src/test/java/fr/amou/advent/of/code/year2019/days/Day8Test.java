package fr.amou.advent.of.code.year2019.days;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {

    @Test
    void part1_example1() {
        // Given
        String imageData = "123456789012";
        Integer layerSize = 6;

        // When
        List<String> result = Day8.splitDataToLayers(imageData, layerSize);

        // Then
        assertThat(result).isEqualTo(List.of("123456", "789012"));
    }
}