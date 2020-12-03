package fr.amou.advent.of.code.year2019.days;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class Day2Test {

    @Test
    @DisplayName("1,0,0,0,99 should become 2,0,0,0,99")
    void part1Example1() {
        List<Integer> resultList = Day2.computeInstructions(Arrays.asList(1, 0, 0, 0, 99));
        assertThat(resultList).isEqualTo(Arrays.asList(2, 0, 0, 0, 99));
    }

    @Test
    @DisplayName("2,3,0,3,99 should become 2,3,0,6,99")
    void part1Example2() {
        List<Integer> resultList = Day2.computeInstructions(Arrays.asList(2, 3, 0, 3, 99));
        assertThat(resultList).isEqualTo(Arrays.asList(2, 3, 0, 6, 99));
    }

    @Test
    @DisplayName("2,4,4,5,99,0 should become 2,4,4,5,99,9801")
    void part1Example3() {
        List<Integer> resultList = Day2.computeInstructions(Arrays.asList(2, 4, 4, 5, 99, 0));
        assertThat(resultList).isEqualTo(Arrays.asList(2, 4, 4, 5, 99, 9801));
    }

    @Test
    @DisplayName("1,1,1,4,99,5,6,0,99 should become 30,1,1,4,2,5,6,0,99")
    void part1Example4() {
        List<Integer> resultList = Day2.computeInstructions(Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99));
        assertThat(resultList).isEqualTo(Arrays.asList(30, 1, 1, 4, 2, 5, 6, 0, 99));
    }
}
