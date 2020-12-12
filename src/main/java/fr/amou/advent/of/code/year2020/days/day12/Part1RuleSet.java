package fr.amou.advent.of.code.year2020.days.day12;

import java.util.Map;
import java.util.Optional;

import static fr.amou.advent.of.code.year2020.days.day12.Action.E;
import static fr.amou.advent.of.code.year2020.days.day12.Action.N;

public class Part1RuleSet implements InstructionRuleSet {

    @Override
    public void resolveRule(Ship ship, Direction direction) {
        Map<Action, Integer> shipPosition = ship.getShipPosition();
        Action facingDirection = ship.getFacingDirection();

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
                resolveRule(ship, new Direction(facingDirection, direction.getPosition()));
                break;
            default:
                break;
        }

        ship.setShipPosition(shipPosition);
        ship.setFacingDirection(facingDirection);
    }
}
