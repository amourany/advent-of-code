package fr.amou.advent.of.code.year2020.days.day13;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.entry;

public class Day13 extends Day2020 {

    public Day13() {
        super(13);
    }

    public static void main(String[] args) throws IOException {
        new Day13().printParts();
    }

    private static Integer findNextBusDeparture(Integer busId, Integer currentTimestamp) {
        int nbOfBusDeparture = currentTimestamp / busId;
        return busId * (nbOfBusDeparture + 1);
    }

    private static Map<Integer, Integer> findNextDepartureForAllBus(List<Integer> busTimeTable,
                                                                    Integer currentTimestamp) {
        return busTimeTable.stream()
                .map(bus -> {
                    Integer nextDeparture = findNextBusDeparture(bus, currentTimestamp);
                    return entry(bus, nextDeparture);
                })
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Long chineseRemainderTheorem(List<Integer> busTimeTable) {

        List<List<Long>> busEntries = IntStream.range(0, busTimeTable.size())
                .filter(index -> busTimeTable.get(index) != 1)
                .mapToObj(index -> List.of(busTimeTable.get(index)
                        .longValue(), (long) index))
                .collect(Collectors.toList());

        Long product = busEntries.stream()
                .map(entry -> entry.get(0))
                .reduce(1L, (left, right) -> left * right);

        List<Long> partialProduct = busEntries.stream()
                .map(entry -> product / entry.get(0))
                .collect(Collectors.toList());

        List<Long> inverse = IntStream.range(0, busEntries.size())
                .boxed()
                .map(index -> computeInverse(
                        partialProduct.get(index), busEntries.get(index)
                                .get(0)))
                .collect(Collectors.toList());

        Long sum = IntStream.range(0, busEntries.size())
                .boxed()
                .map(index -> partialProduct.get(index) * inverse.get(index) * busEntries.get(index)
                        .get(1))
                .reduce(0L, Long::sum);

        return product - sum % product;
    }

    private static Long computeInverse(Long x, Long y) {
        if (x != 0) {
            long modulo = y % x;
            return modulo == 0 ? 1 : y - computeInverse(modulo, x) * y / x;
        }
        return 0L;
    }

    public static Integer findEarliestDeparture(List<Integer> busTimeTable, Integer currentTimestamp) {
        Map<Integer, Integer> departureTable = findNextDepartureForAllBus(busTimeTable, currentTimestamp);
        Entry<Integer, Integer> earliestBus = departureTable.entrySet()
                .stream()
                .reduce(Map.entry(0, Integer.MAX_VALUE), (bus, bus1) -> bus.getValue() < bus1.getValue() ? bus : bus1);

        Integer timeToWait = earliestBus.getValue() - currentTimestamp;
        return earliestBus.getKey() * timeToWait;
    }

    @Override
    public Object part1() throws IOException {
        List<String> inputData = readDataAsList();
        Integer currentTimeStamp = Integer.parseInt(inputData.get(0));
        List<Integer> busTimetable = Arrays.stream(inputData.get(1)
                .split(","))
                .filter(bus -> !bus.contains("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return findEarliestDeparture(busTimetable, currentTimeStamp);
    }

    @Override
    public Object part2() throws IOException {
        List<String> inputData = readDataAsList();
        List<Integer> busTimetable = Arrays.stream(inputData.get(1)
                .split(","))
                .map(bus -> bus.contains("x") ? "1" : bus)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return chineseRemainderTheorem(busTimetable);
    }
}
