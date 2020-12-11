package fr.amou.advent.of.code.year2020.days.day11;

import fr.amou.advent.of.code.year2020.days.day11.seat.NextSeatStatusProvider;
import fr.amou.advent.of.code.year2020.days.day11.seat.Seat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;

import static fr.amou.advent.of.code.year2020.days.day11.seat.SeatStatus.OCCUPIED;

class Day11Test {

    @Test
    void part1_example1() {
        // Given
        List<String> seatsLayout = List.of("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL",
                "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL");

        Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> provider = NextSeatStatusProvider::part1Provider;

        // When
        Map<String, Seat> finalSeatsOccupation = Day11.simulatePeopleArriving(seatsLayout, provider);
        long occupiedSeats = finalSeatsOccupation.values()
                .stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();

        // Then
        Assertions.assertThat(occupiedSeats)
                .isEqualTo(37);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> seatsLayout = List.of("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL",
                "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL");

        Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> provider = NextSeatStatusProvider::part2Provider;

        // When
        Map<String, Seat> finalSeatsOccupation = Day11.simulatePeopleArriving(seatsLayout, provider);
        long occupiedSeats = finalSeatsOccupation.values()
                .stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();

        // Then
        Assertions.assertThat(occupiedSeats)
                .isEqualTo(26);
    }
}