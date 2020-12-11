package fr.amou.advent.of.code.year2020.days.day11;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static fr.amou.advent.of.code.year2020.days.day11.SeatStatus.EMPTY;
import static fr.amou.advent.of.code.year2020.days.day11.SeatStatus.OCCUPIED;

public class NextSeatStatusFromOccupied implements NextSeatStatus {

    @Override
    public Entry<String, Seat> apply(Entry<String, Seat> currentSeat, Map<String, Seat> seatOccupation) {
        String[] seatPosition = currentSeat.getValue()
                .getSeatPosition()
                .split("-");
        int seatRow = Integer.parseInt(seatPosition[0]);
        int seatColumn = Integer.parseInt(seatPosition[1]);

        List<Seat> adjacentSeats = findAdjacentSeats(seatRow, seatColumn, seatOccupation);

        long nbOfAdjacentOccupiedSeats = adjacentSeats.stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();

        if (nbOfAdjacentOccupiedSeats >= 4) {
            Seat newSeatStatus = new Seat(seatRow, seatColumn, EMPTY);
            return Map.entry(currentSeat.getKey(), newSeatStatus);
        }

        return currentSeat;
    }
}
