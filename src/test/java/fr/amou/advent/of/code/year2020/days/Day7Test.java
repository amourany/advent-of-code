package fr.amou.advent.of.code.year2020.days;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.amou.advent.of.code.year2020.days.Day7.countContainingBags;
import static fr.amou.advent.of.code.year2020.days.Day7.countTotalBags;
import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    @Test
    void part1_example1() {
        // Given
        List<String> ruleset = List.of("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.", "dotted black bags contain no other bags.");

        // When
        int result = countContainingBags(ruleset);

        // Then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> ruleset = List.of("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.", "dotted black bags contain no other bags.");

        // When
        int result = countTotalBags(ruleset);

        // Then
        assertThat(result).isEqualTo(32);
    }

    @Test
    void part2_example2() {
        // Given
        List<String> ruleset = List.of("shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.", "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.", "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.", "dark violet bags contain no other bags.");

        // When
        int result = countTotalBags(ruleset);

        // Then
        assertThat(result).isEqualTo(126);
    }
}