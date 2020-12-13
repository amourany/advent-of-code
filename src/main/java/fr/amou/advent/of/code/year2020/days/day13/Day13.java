package fr.amou.advent.of.code.year2020.days.day13;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
        return null;
    }
}
