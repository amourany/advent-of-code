package fr.amou.advent.of.code.year2020.days.day11;

import lombok.Getter;

@Getter
public class Seat {

    private final String seatPosition;
    private final SeatStatus seatStatus;

    public Seat(Integer rowIndex, Integer columnIndex, String seatStatus) {
        this.seatPosition = rowIndex + "-" + columnIndex;
        this.seatStatus = SeatStatus.fromLayoutRepresentation(seatStatus);
    }

    public Seat(Integer rowIndex, Integer columnIndex, SeatStatus seatStatus) {
        this.seatPosition = rowIndex + "-" + columnIndex;
        this.seatStatus = seatStatus;
    }
}
