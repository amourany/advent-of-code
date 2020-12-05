package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 extends Day2020 {

    private static final UnaryOperator<List<Integer>> LOWER_HALF_FUNCTION = seatRange -> seatRange.subList(
            0, seatRange.size() / 2 + 1);
    private static final UnaryOperator<List<Integer>> UPPER_HALF_FUNCTION = seatRange -> seatRange.subList(
            (seatRange.size() / 2), seatRange.size());

    public Day5() {
        super(5);
    }

    public static void main(String[] args) throws IOException {
        new Day5().printParts();
    }

    public static Integer computeSeatId(String seatPartitioning) {
        List<Integer> seatRows = IntStream.range(0, 128)
                .boxed()
                .collect(Collectors.toList());
        Integer seatRow = findSeat(seatPartitioning.substring(0, 7), seatRows);

        List<Integer> seatNumbers = IntStream.range(0, 8)
                .boxed()
                .collect(Collectors.toList());
        Integer seatNumber = findSeat(seatPartitioning.substring(7, 10), seatNumbers);

        return seatRow * 8 + seatNumber;
    }

    private static Integer findSeat(String seatPartitioning, List<Integer> possibleSeats) {
        AtomicReference<List<Integer>> possibleRows = new AtomicReference<>(possibleSeats);

        seatPartitioning.chars()
                .mapToObj(c -> (char) c)
                .map(partitioner -> SeatPartitioner.valueOf(partitioner.toString()))
                .forEach(partitioner -> possibleRows.set(partitioner.getReduceScopeFunction()
                        .apply(possibleRows.get())));
        return possibleRows.get()
                .get(0);
    }

    @Override
    public Object part1() throws IOException {
        List<String> partitioners = readDataAsList();
        return partitioners.stream()
                .map(Day5::computeSeatId)
                .reduce(0, Math::max);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }

    enum SeatPartitioner {
        F(LOWER_HALF_FUNCTION),
        B(UPPER_HALF_FUNCTION),
        L(LOWER_HALF_FUNCTION),
        R(UPPER_HALF_FUNCTION);

        @Getter
        private final UnaryOperator<List<Integer>> reduceScopeFunction;

        SeatPartitioner(UnaryOperator<List<Integer>> reduceScopeFunction) {
            this.reduceScopeFunction = reduceScopeFunction;
        }
    }
}
