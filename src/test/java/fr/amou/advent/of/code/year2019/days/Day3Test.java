package fr.amou.advent.of.code.year2019.days;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class Day3Test {

    @Test
    @DisplayName("For wires : R75,D30,R83,U83,L12,D49,R71,U7,L72 and U62,R66,U55,R34,D71,R55,D58,R83 = distance 159")
    void part1Example1() {
        List<String> wire1 = Arrays.asList("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72");
        List<String> wire2 = Arrays.asList("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83");

        Integer distance = Day3.computeDistance(wire1, wire2);
        assertThat(distance).isEqualTo(159);
    }

    @Test
    @DisplayName("For wires : R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51 and U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = distance 135")
    void part1Example2() {
        List<String> wire1 = Arrays.asList("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51");
        List<String> wire2 = Arrays.asList("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7");

        Integer distance = Day3.computeDistance(wire1, wire2);
        assertThat(distance).isEqualTo(135);
    }

    @Test
    @DisplayName("For wires : R75,D30,R83,U83,L12,D49,R71,U7,L72 and U62,R66,U55,R34,D71,R55,D58,R83 = steps 610")
    void part2Example1() {
        List<String> wire1 = Arrays.asList("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72");
        List<String> wire2 = Arrays.asList("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83");

        Integer steps = Day3.computeSteps(wire1, wire2);
        assertThat(steps).isEqualTo(610);
    }

    @Test
    @DisplayName("For wires : R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51 and U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = steps 410")
    void part2Example2() {
        List<String> wire1 = Arrays.asList("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51");
        List<String> wire2 = Arrays.asList("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7");

        Integer steps = Day3.computeSteps(wire1, wire2);
        assertThat(steps).isEqualTo(410);
    }
}
