package fr.amou.advent.of.code.year2020.days.day12;

import java.util.Map;
import java.util.Optional;

import static fr.amou.advent.of.code.year2020.days.day12.Action.E;
import static fr.amou.advent.of.code.year2020.days.day12.Action.N;

public class Part2RuleSet implements InstructionRuleSet {

    @Override
    public void resolveRule(Ship ship, Direction direction) {
        Map<Action, Integer> shipPosition = ship.getShipPosition();
        Map<Action, Integer> waypointPosition = ship.getWaypointPosition();

        Integer shipVerticalPosition = Optional.ofNullable(shipPosition.get(N))
                .orElse(0);
        Integer shipHorizontalPosition = Optional.ofNullable(shipPosition.get(E))
                .orElse(0);

        Integer waypointVerticalPosition = Optional.ofNullable(waypointPosition.get(N))
                .orElse(1);
        Integer waypointHorizontalPosition = Optional.ofNullable(waypointPosition.get(E))
                .orElse(10);

        Integer movementValue = direction.getPosition();

        switch (direction.getDirection()) {
            case N:
                waypointPosition.put(N, waypointVerticalPosition + movementValue);
                break;
            case S:
                waypointPosition.put(N, waypointVerticalPosition - movementValue);
                break;
            case E:
                waypointPosition.put(E, waypointHorizontalPosition + movementValue);
                break;
            case W:
                waypointPosition.put(E, waypointHorizontalPosition - movementValue);
                break;
            case L:
                waypointPosition.put(E, waypointVerticalPosition * -1);
                waypointPosition.put(N, waypointHorizontalPosition);

                if (direction.getPosition() > 90) {
                    resolveRule(ship, new Direction(direction.getDirection(), direction.getPosition() - 90));
                }
                break;
            case R:
                waypointPosition.put(E, waypointVerticalPosition);
                waypointPosition.put(N, waypointHorizontalPosition * -1);

                if (direction.getPosition() > 90) {
                    resolveRule(ship, new Direction(direction.getDirection(), direction.getPosition() - 90));
                }
                break;
            case F:
                shipVerticalPosition += movementValue * waypointVerticalPosition;
                shipHorizontalPosition += movementValue * waypointHorizontalPosition;
                shipPosition.put(N, shipVerticalPosition);
                shipPosition.put(E, shipHorizontalPosition);
                break;
            default:
                break;
        }

        ship.setShipPosition(shipPosition);
        ship.setWaypointPosition(waypointPosition);
    }
}
