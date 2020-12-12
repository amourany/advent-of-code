package fr.amou.advent.of.code.year2020.days.day12;

import java.util.List;

public enum Action {
    N,
    S,
    E,
    W,
    L,
    R,
    F;

    public static Action rightRotation(Direction direction) {
        List<Action> rotations = List.of(N, E, S, W);
        int directionOffset = direction.getPosition() / 90;
        int directionIndex = rotations.indexOf(direction.getDirection());

        return rotations.get((directionOffset + directionIndex) % 4);
    }

    public static Action leftRotation(Direction direction) {
        List<Action> rotations = List.of(N, W, S, E);
        int directionOffset = direction.getPosition() / 90;
        int directionIndex = rotations.indexOf(direction.getDirection());

        return rotations.get((directionOffset + directionIndex) % 4);
    }
}
