package fr.amou.advent.of.code.year2020.days.day12;

import lombok.Data;

import java.util.EnumMap;
import java.util.Map;

import static fr.amou.advent.of.code.year2020.days.day12.Action.E;

@Data
public class Ship {

    private Map<Action, Integer> shipPosition;
    private Map<Action, Integer> waypointPosition;
    private Action facingDirection;

    public Ship() {
        this.shipPosition = new EnumMap<>(Action.class);
        this.waypointPosition = new EnumMap<>(Action.class);
        this.facingDirection = E;
    }
}
