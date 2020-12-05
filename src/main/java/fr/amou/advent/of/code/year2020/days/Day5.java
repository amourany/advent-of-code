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

    public static Integer parseSeatId(String seatPartitioning) {
        List<Integer> seatRows = IntStream.rangeClosed(0, 127)
                .boxed()
                .collect(Collectors.toList());
        Integer seatRow = findSeat(seatPartitioning.substring(0, 7), seatRows);

        List<Integer> seatNumbers = IntStream.rangeClosed(0, 7)
                .boxed()
                .collect(Collectors.toList());
        Integer seatNumber = findSeat(seatPartitioning.substring(7, 10), seatNumbers);

        return computeSeatId(seatRow, seatNumber);
    }

    private static Integer computeSeatId(Integer row, Integer seat) {
        return row * 8 + seat;
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

    private static List<Integer> buildAllSeatsIds() {
        return IntStream.range(1, 127)
                .boxed()
                .map(row -> IntStream.rangeClosed(0, 7)
                        .boxed()
                        .map(seat -> computeSeatId(row, seat))
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Object part1() throws IOException {
        List<String> partitioners = readDataAsList();
        return partitioners.stream()
                .map(Day5::parseSeatId)
                .reduce(0, Math::max);
    }

    @Override
    public Object part2() throws IOException {
        List<Integer> allSeats = buildAllSeatsIds();

        List<String> partitioners = readDataAsList();
        List<Integer> occupiedSeats = partitioners.stream()
                .map(Day5::parseSeatId)
                .collect(Collectors.toList());

        allSeats.removeAll(occupiedSeats);

        return allSeats.get(0);
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
