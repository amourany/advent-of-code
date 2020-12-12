package fr.amou.advent.of.code.year2020.days.day12;

import lombok.Getter;

@Getter
public class Direction {

    private final Action direction;
    private final Integer position;

    public Direction(String direction, String position) {
        this.direction = Action.valueOf(direction);
        this.position = Integer.parseInt(position);
    }

    public Direction(Action direction, Integer position) {
        this.direction = direction;
        this.position = position;
    }
}
