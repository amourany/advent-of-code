package fr.amou.advent.of.code.year2020.days.day11.seat;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class NextSeatStatusForFloor implements NextSeatStatus {

    @Override
    public BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part1() {
        return (currentSeat, seatOccupation) -> currentSeat;
    }

    @Override
    public BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part2() {
        return (currentSeat, seatOccupation) -> currentSeat;
    }
}
