package fr.amou.advent.of.code.year2020.days.day11.seat;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum SeatStatus {
    EMPTY("L"),
    OCCUPIED("#"),
    FLOOR(".");

    private final String layoutRepresentation;

    SeatStatus(String layoutRepresentation) {
        this.layoutRepresentation = layoutRepresentation;
    }

    public static SeatStatus fromLayoutRepresentation(String representation) {
        return Arrays.stream(SeatStatus.values())
                .filter(status -> StringUtils.equals(status.layoutRepresentation, representation))
                .findFirst()
                .get();
    }
}
