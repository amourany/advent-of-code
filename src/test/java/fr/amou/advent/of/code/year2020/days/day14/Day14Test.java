package fr.amou.advent.of.code.year2020.days.day14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class Day14Test {

    @Test
    void part1_example1() {
        // Given
        List<String> instructionList = List.of(
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\nmem[8] = 11\nmem[7] = 101\nmem[8] = 0");
        DecoderChipV1 decoder = new DecoderChipV1();

        // When
        Map<Integer, String> memory = decoder.decode(instructionList);
        Long result = decoder.sumMemoryValues(memory);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(165);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> instructionList = List.of(
                "000000000000000000000000000000X1001X\nmem[42] = 100",
                "00000000000000000000000000000000X0XX\nmem[26] = 1");
        DecoderChipV2 decoder = new DecoderChipV2();

        // When
        Map<? extends Number, String> memory = decoder.decode(instructionList);
        Long result = decoder.sumMemoryValues(memory);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(208);
    }
}