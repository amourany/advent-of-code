package fr.amou.advent.of.code.year2020.days.day11.seat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.year2020.days.day11.seat.SeatStatus.FLOOR;

public interface NextSeatStatus {

    BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part1();

    BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part2();

    default List<Seat> findAdjacentSeats(Integer seatRow, Integer seatColumn, Map<String, Seat> seatOccupation) {
        return IntStream.rangeClosed(seatRow - 1, seatRow + 1)
                .boxed()
                .map(row -> IntStream.rangeClosed(seatColumn - 1, seatColumn + 1)
                        .boxed()
                        .filter(column -> !(row.equals(seatRow) && column.equals(seatColumn)))
                        .map(column -> Optional.ofNullable(seatOccupation.get(row + "-" + column)))
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    default List<Seat> findSeatsInLOS(Integer seatRow, Integer seatColumn, Map<String, Seat> seatOccupation) {
        return Arrays.stream(LOSDirection.values())
                .map(losDirection -> {

                    Optional<Seat> nextSeatInLine = Optional.of(new Seat(0, 0, FLOOR));
                    Integer[] seatPosition = new Integer[]{seatRow, seatColumn};

                    while (nextSeatInLine.isPresent() && nextSeatInLine.get()
                            .getSeatStatus() == FLOOR) {
                        seatPosition = losDirection.getNextIndexInLOS()
                                .apply(seatPosition);
                        nextSeatInLine = Optional.ofNullable(
                                seatOccupation.get(seatPosition[0] + "-" + seatPosition[1]));
                    }

                    return nextSeatInLine;
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
