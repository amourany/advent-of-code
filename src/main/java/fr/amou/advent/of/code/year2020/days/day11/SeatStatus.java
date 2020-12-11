package fr.amou.advent.of.code.year2020.days.day11;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum SeatStatus {
    EMPTY("L", new NextSeatStatusFromEmpty()),
    OCCUPIED("#", new NextSeatStatusFromOccupied()),
    FLOOR(".", new NextSeatStatusForFloor());

    private final String layoutRepresentation;
    private final NextSeatStatus nextStatus;

    SeatStatus(String layoutRepresentation, NextSeatStatus nextStatus) {
        this.layoutRepresentation = layoutRepresentation;
        this.nextStatus = nextStatus;
    }

    public static SeatStatus fromLayoutRepresentation(String representation) {
        return Arrays.stream(SeatStatus.values())
                .filter(status -> StringUtils.equals(status.layoutRepresentation, representation))
                .findFirst()
                .get();
    }
}
