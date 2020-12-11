package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.days.day11.Seat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static fr.amou.advent.of.code.year2020.days.day11.SeatStatus.OCCUPIED;

class Day11Test {

    @Test
    void part1_example1() {
        // Given
        List<String> seatsLayout = List.of("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL",
                "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL");

        // When
        Map<String, Seat> finalSeatsOccupation = Day11.simulatePeopleArriving(seatsLayout);
        long occupiedSeats = finalSeatsOccupation.values()
                .stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();

        // Then
        Assertions.assertThat(occupiedSeats)
                .isEqualTo(37);
    }
}