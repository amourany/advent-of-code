package fr.amou.advent.of.code.year2020.days.day11.seat;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class NextSeatStatusProvider {

    public static BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part1Provider(Seat seat) {
        switch (seat.getSeatStatus()) {
            case EMPTY:
                return new NextSeatStatusFromEmpty().part1();
            case OCCUPIED:
                return new NextSeatStatusFromOccupied().part1();
            case FLOOR:
            default:
                return new NextSeatStatusForFloor().part1();
        }
    }

    public static BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part2Provider(Seat seat) {
        switch (seat.getSeatStatus()) {
            case EMPTY:
                return new NextSeatStatusFromEmpty().part2();
            case OCCUPIED:
                return new NextSeatStatusFromOccupied().part2();
            case FLOOR:
            default:
                return new NextSeatStatusForFloor().part2();
        }
    }
}
