package fr.amou.advent.of.code.year2020.days.day17;

import fr.amou.advent.of.code.year2020.days.day17.cube.Cube;
import fr.amou.advent.of.code.year2020.days.day17.cube.CubeStatus;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;
import static fr.amou.advent.of.code.year2020.days.day17.cube.Cube.CubeBuilder.aCube;
import static fr.amou.advent.of.code.year2020.days.day17.cube.CubeStatus.*;
import static java.util.Arrays.asList;
import static java.util.Map.entry;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

public class Universe {

    private final Map<Cube, List<Cube>> knownNeighbors = new HashMap<>();
    private Map<Cube, CubeStatus> knownUniverse;

    public Universe(String initialState, Integer maxDimensions) {
        List<String> cubeXStates = asList(initialState.split(DEFAULT_DELIMITER));

        knownUniverse = range(0, cubeXStates.size())
                .mapToObj(xIndex -> {
                    List<String> cubeYStates = asList(cubeXStates
                            .get(xIndex)
                            .split(""));

                    return range(0, cubeYStates.size()).mapToObj(
                            yIndex -> entry(buildCube(maxDimensions, xIndex, yIndex),
                                    getStatusFromRepresentation(cubeYStates.get(yIndex))));
                })
                .flatMap(Function.identity())
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    private Cube buildCube(Integer dimensions, Integer... coordinates) {
        return aCube()
                .withNDimensions(dimensions)
                .withCoordinates(coordinates)
                .build();
    }

    public List<Cube> findNeighborsOfCube(Cube cube) {
        List<Cube> neighbors = findNeighbors(cube.getCoordinates())
                .stream()
                .map(Cube::new)
                .filter(neighbor -> !neighbor.equals(cube))
                .collect(toList());
        knownNeighbors.put(cube, neighbors);
        return neighbors;
    }

    private List<List<Integer>> findNeighbors(List<Integer> originCoordinates) {
        if (originCoordinates.size() == 1) {
            return IntStream
                    .rangeClosed(-1, 1)
                    .mapToObj(offset -> List.of(originCoordinates.get(0) + offset))
                    .collect(toList());
        }

        return IntStream
                .rangeClosed(-1, 1)
                .mapToObj(offset -> {
                    List<List<Integer>> neighbors = findNeighbors(
                            originCoordinates.subList(1, originCoordinates.size()));

                    return neighbors
                            .stream()
                            .map(neighbor -> {
                                List<Integer> mergedCoordinates = new ArrayList<>();
                                mergedCoordinates.add(originCoordinates.get(0) + offset);
                                mergedCoordinates.addAll(neighbor);
                                return mergedCoordinates;
                            })
                            .collect(toList());
                })
                .flatMap(List::stream)
                .collect(toList());
    }

    public void expand() {
        Set<Cube> knownCoordinates = exploreKnownCoordinates();

        knownUniverse = knownCoordinates
                .stream()
                .map(coordinates -> Optional
                        .ofNullable(knownUniverse.get(coordinates))
                        .map(status -> entry(coordinates, status))
                        .orElse(entry(coordinates, INACTIVE)))
                .map(cubeEntry -> {
                    List<Cube> neighbors = Optional
                            .ofNullable(knownNeighbors.get(cubeEntry.getKey()))
                            .orElse(findNeighborsOfCube(cubeEntry.getKey()));

                    long activeNeighbors = neighbors
                            .stream()
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

    private Set<Cube> exploreKnownCoordinates() {
        return knownUniverse
                .keySet()
                .stream()
                .map(this::findNeighborsOfCube)
                .flatMap(List::stream)
                .collect(toSet());
    }

    public long countActiveCubes() {
        return knownUniverse
                .values()
                .stream()
                .filter(status -> status == ACTIVE)
                .count();
    }
}
