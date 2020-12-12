package fr.amou.advent.of.code.year2020.days.day12;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static fr.amou.advent.of.code.year2020.days.day12.Action.E;
import static fr.amou.advent.of.code.year2020.days.day12.Action.N;

@Getter
public class Ship {

    private final Map<Action, Integer> shipPosition;
    private Action facingDirection;

    public Ship() {
        this.shipPosition = new HashMap<>();
        this.facingDirection = E;
    }

    public void moveTo(Direction direction) {

        Integer verticalPosition = Optional.ofNullable(shipPosition.get(N))
                .orElse(0);
        Integer horizontalPosition = Optional.ofNullable(shipPosition.get(E))
                .orElse(0);
        Integer movementValue = direction.getPosition();

        switch (direction.getDirection()) {
            case N:
                shipPosition.put(N, verticalPosition + movementValue);
                break;
            case S:
                shipPosition.put(N, verticalPosition - movementValue);
                break;
            case E:
                shipPosition.put(E, horizontalPosition + movementValue);
                break;
            case W:
                shipPosition.put(E, horizontalPosition - movementValue);
                break;
            case L:
                facingDirection = Action.leftRotation(new Direction(facingDirection, direction.getPosition()));
                break;
            case R:
                facingDirection = Action.rightRotation(new Direction(facingDirection, direction.getPosition()));
                break;
            case F:
                moveTo(new Direction(facingDirection, direction.getPosition()));
                break;
            default:
                break;
        }
    }
}
