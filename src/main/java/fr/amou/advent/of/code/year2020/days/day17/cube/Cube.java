package fr.amou.advent.of.code.year2020.days.day17.cube;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cube {

    @Getter
    private final List<Integer> coordinates;

    public Cube(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return Objects.equals(coordinates, cube.coordinates);
    }

    public static class CubeBuilder {

        private int dimensions;
        private Integer[] partialCoordinates;

        public static CubeBuilder aCube() {
            return new CubeBuilder();
        }

        public CubeBuilder withNDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public CubeBuilder withCoordinates(Integer... coordinates) {
            this.partialCoordinates = coordinates;
            return this;
        }

        public Cube build() {

            List<Integer> coordinates = IntStream
                    .range(0, dimensions)
                    .mapToObj(index -> Optional
                            .of(partialCoordinates.length)
                            .filter(length -> length > index)
                            .map(length -> partialCoordinates[index])
                            .orElse(0))
                    .collect(Collectors.toList());

            return new Cube(coordinates);
        }
    }
}
