package fr.amou.advent.of.code.year2020.days.day17;

import lombok.Getter;

import java.util.Objects;

@Getter
public class CubeCoordinates {

    private final int x;
    private final int y;
    private final int z;

    public CubeCoordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeCoordinates that = (CubeCoordinates) o;
        return x == that.x && y == that.y && z == that.z;
    }

    public Integer[] toCoordinateArray() {
        return new Integer[]{x, y, z};
    }
}
