package fr.amou.advent.of.code.year2020.days.day11;

import fr.amou.advent.of.code.year2020.Day2020;
import fr.amou.advent.of.code.year2020.days.day11.seat.NextSeatStatusProvider;
import fr.amou.advent.of.code.year2020.days.day11.seat.Seat;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.year2020.days.day11.seat.SeatStatus.OCCUPIED;
import static java.util.Map.entry;

public class Day11 extends Day2020 {

    public Day11() {
        super(11);
    }

    public static void main(String[] args) throws IOException {
        new Day11().printParts();
    }

    private static Map<String, Seat> convertSeatsLayout(List<String> seatsLayout) {
        return IntStream.range(0, seatsLayout.size())
                .mapToObj(rowIndex -> {
                    String[] rowStatus = seatsLayout.get(rowIndex)
                            .split("");

                    return IntStream.range(0, rowStatus.length)
                            .mapToObj(columnIndex -> new Seat(rowIndex, columnIndex, rowStatus[columnIndex]))
                            .map(seat -> entry(seat.getSeatPosition(), seat))
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private static Map<String, Seat> updateSeats(Map<String, Seat> seatsOccupation,
                                                 Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> seatRulesProvider) {
        return seatsOccupation.entrySet()
                .stream()
                .map(seatEntry -> changeSeatStatus(seatEntry, seatsOccupation, seatRulesProvider))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private static Entry<String, Seat> changeSeatStatus(Entry<String, Seat> seat, Map<String, Seat> seatsOccupation,
                                                        Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> seatRulesProvider) {
        return seatRulesProvider.apply(seat.getValue())
                .apply(seat, seatsOccupation);
    }

    public static Map<String, Seat> simulatePeopleArriving(List<String> seatsLayout,
                                                           Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> seatRulesProvider) {
        Map<String, Seat> seatsOccupation = convertSeatsLayout(seatsLayout);

        boolean isStabilized = false;
        Map<String, Seat> newOccupation = new HashMap<>();

        while (!isStabilized) {
            newOccupation = updateSeats(seatsOccupation, seatRulesProvider);

            isStabilized = seatsOccupation.equals(newOccupation);

            if (!isStabilized) {
                seatsOccupation = newOccupation;
            }
        }

        return newOccupation;
    }

    @Override
    public Object part1() throws IOException {
        List<String> seatsLayout = readDataAsList();
        Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> seatRulesProvider = NextSeatStatusProvider::part1Provider;
        Map<String, Seat> finalSeatsOccupation = Day11.simulatePeopleArriving(seatsLayout, seatRulesProvider);
        return finalSeatsOccupation.values()
                .stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();
    }

    @Override
    public Object part2() throws IOException {
        List<String> seatsLayout = readDataAsList();
        Function<Seat, BiFunction<Entry<String, Seat>, Map<String, Seat>, Entry<String, Seat>>> seatRulesProvider = NextSeatStatusProvider::part2Provider;
        Map<String, Seat> finalSeatsOccupation = Day11.simulatePeopleArriving(seatsLayout, seatRulesProvider);
        return finalSeatsOccupation.values()
                .stream()
                .filter(seat -> seat.getSeatStatus() == OCCUPIED)
                .count();
    }
}
