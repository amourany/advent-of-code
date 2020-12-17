package fr.amou.advent.of.code.year2020.days.day17;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;
import static fr.amou.advent.of.code.year2020.days.day17.CubeStatus.*;
import static java.util.Arrays.asList;
import static java.util.Map.entry;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

public class Universe {

    private Map<CubeCoordinates, CubeStatus> knownUniverse;

    public Universe(String initialState) {
        List<String> cubeXStates = asList(initialState.split(DEFAULT_DELIMITER));
        knownUniverse = range(0, cubeXStates.size()).mapToObj(xIndex -> {
            List<String> cubeYStates = asList(cubeXStates.get(xIndex)
                    .split(""));
            return range(0, cubeYStates.size()).mapToObj(yIndex -> entry(new CubeCoordinates(xIndex, yIndex, 0),
                    getStatusFromRepresentation(cubeYStates.get(yIndex))));
        })
                .flatMap(Function.identity())
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    public List<CubeCoordinates> findNeighborsOfCube(CubeCoordinates cube) {
        return findNeighbors(cube.getX(), cube.getY(), cube.getZ()).stream()
                .map(neighborCoordinate -> new CubeCoordinates(neighborCoordinate[0], neighborCoordinate[1],
                        neighborCoordinate[2]))
                .filter(neighbor -> !neighbor.equals(cube))
                .collect(toList());
    }

    private List<Integer[]> findNeighbors(Integer... origin) {
        if (origin.length == 1) {
            return IntStream.rangeClosed(-1, 1)
                    .mapToObj(offset -> new Integer[]{origin[0] + offset})
                    .collect(toList());
        }

        return IntStream.rangeClosed(-1, 1)
                .mapToObj(offset -> {
                    List<Integer[]> neighbors = findNeighbors(Arrays.stream(origin, 1, origin.length)
                            .toArray(Integer[]::new));
                    return neighbors.stream()
                            .map(neighbor -> ArrayUtils.addAll(new Integer[]{origin[0] + offset}, neighbor))
                            .collect(toList());
                })
                .flatMap(List::stream)
                .collect(toList());
    }

    public void expand() {
        Set<CubeCoordinates> knownCoordinates = exploreKnownCoordinates();

        knownUniverse = knownCoordinates.stream()
                .map(coordinates -> Optional.ofNullable(knownUniverse.get(coordinates))
                        .map(status -> entry(coordinates, status))
                        .orElse(entry(coordinates, INACTIVE)))
                .map(cubeEntry -> {
                    List<CubeCoordinates> neighbors = findNeighborsOfCube(cubeEntry.getKey());

                    long activeNeighbors = neighbors.stream()
                            .filter(knownUniverse::containsKey)
                            .map(knownUniverse::get)
                            .filter(status -> status == ACTIVE)
                            .count();

                    CubeStatus newStatus = cubeEntry.getValue();

                    if (cubeEntry.getValue() == ACTIVE && (activeNeighbors < 2 || activeNeighbors > 3)) {
                        newStatus = INACTIVE;
                    } else if (cubeEntry.getValue() == INACTIVE && activeNeighbors == 3) {
                        newStatus = ACTIVE;
                    }

                    return entry(cubeEntry.getKey(), newStatus);
                })
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    private Set<CubeCoordinates> exploreKnownCoordinates() {
        return knownUniverse.keySet()
                .stream()
                .map(this::findNeighborsOfCube)
                .flatMap(List::stream)
                .collect(toSet());
    }

    public long countActiveCubes() {
        return knownUniverse.values()
                .stream()
                .filter(status -> status == ACTIVE)
                .count();
    }
}
