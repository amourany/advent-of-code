package fr.amou.advent.of.code.year2020.days.day11.seat;

import lombok.Getter;

import java.util.function.UnaryOperator;

public enum LOSDirection {
    UP(position -> (new Integer[]{position[0] - 1, position[1]})),
    UP_RIGHT(position -> (new Integer[]{position[0] - 1, position[1] + 1})),
    RIGHT(position -> (new Integer[]{position[0], position[1] + 1})),
    BOTTOM_RIGHT(position -> (new Integer[]{position[0] + 1, position[1] + 1})),
    DOWN(position -> (new Integer[]{position[0] + 1, position[1]})),
    DOWN_LEFT(position -> (new Integer[]{position[0] + 1, position[1] - 1})),
    LEFT(position -> (new Integer[]{position[0], position[1] - 1})),
    UP_LEFT(position -> (new Integer[]{position[0] - 1, position[1] - 1}));

    @Getter
    private final UnaryOperator<Integer[]> nextIndexInLOS;

    LOSDirection(UnaryOperator<Integer[]> nextIndexInLOS) {
        this.nextIndexInLOS = nextIndexInLOS;
    }
}
