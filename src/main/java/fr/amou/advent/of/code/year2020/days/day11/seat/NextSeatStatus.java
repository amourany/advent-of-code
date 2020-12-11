package fr.amou.advent.of.code.year2020.days.day11.seat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface NextSeatStatus extends BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> {

    Entry<String, Seat> apply(Entry<String, Seat> currentSeat, Map<String, Seat> seatOccupation);

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
}
