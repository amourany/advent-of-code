package fr.amou.advent.of.code.year2020.days.day17;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum CubeStatus {
    ACTIVE("#"),
    INACTIVE(".");

    @Getter
    private final String representation;

    CubeStatus(String representation) {
        this.representation = representation;
    }

    public static CubeStatus getStatusFromRepresentation(String statusRepresentation) {
        return Arrays.stream(CubeStatus.values())
                .filter(representation -> StringUtils.equals(representation.getRepresentation(), statusRepresentation))
                .findFirst()
                .get();
    }
}
