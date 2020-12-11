package fr.amou.advent.of.code.year2020.days.day11.seat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

import static fr.amou.advent.of.code.year2020.days.day11.seat.SeatStatus.OCCUPIED;

public class NextSeatStatusFromEmpty implements NextSeatStatus {

    @Override
    public BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part1() {
        return (currentSeat, seatOccupation) -> {
            String[] seatPosition = currentSeat.getValue()
                    .getSeatPosition()
                    .split("-");
            int seatRow = Integer.parseInt(seatPosition[0]);
            int seatColumn = Integer.parseInt(seatPosition[1]);

            List<Seat> adjacentSeats = findAdjacentSeats(seatRow, seatColumn, seatOccupation);

            boolean noSeatsAreOccupied = adjacentSeats.stream()
                    .noneMatch(seat -> seat.getSeatStatus() == OCCUPIED);

            if (noSeatsAreOccupied) {
                Seat newSeatStatus = new Seat(seatRow, seatColumn, OCCUPIED);
                return Map.entry(currentSeat.getKey(), newSeatStatus);
            }

            return currentSeat;
        };
    }

    @Override
    public BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>> part2() {
        return (currentSeat, seatOccupation) -> {
            String[] seatPosition = currentSeat.getValue()
                    .getSeatPosition()
                    .split("-");
            int seatRow = Integer.parseInt(seatPosition[0]);
            int seatColumn = Integer.parseInt(seatPosition[1]);

            List<Seat> adjacentSeats = findSeatsInLOS(seatRow, seatColumn, seatOccupation);

            boolean noSeatsAreOccupied = adjacentSeats.stream()
                    .noneMatch(seat -> seat.getSeatStatus() == OCCUPIED);

            if (noSeatsAreOccupied) {
                Seat newSeatStatus = new Seat(seatRow, seatColumn, OCCUPIED);
                return Map.entry(currentSeat.getKey(), newSeatStatus);
            }

            return currentSeat;
        };
    }
}
