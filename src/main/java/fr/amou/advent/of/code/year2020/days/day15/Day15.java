package fr.amou.advent.of.code.year2020.days.day15;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day15 extends Day2020 {

    public Day15() {
        super(15);
    }

    public static void main(String[] args) throws IOException {
        new Day15().printParts();
    }

    public static Map<Integer, Integer[]> playStartingRounds(List<Integer> startingNumbers) {
        return IntStream.range(0, startingNumbers.size())
                .mapToObj(roundNumber -> Map.entry(startingNumbers.get(roundNumber), new Integer[]{0, roundNumber + 1}))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<Integer, Integer[]> playGame(List<Integer> startingNumber, Integer maxRound) {

        Map<Integer, Integer[]> previousRounds = playStartingRounds(startingNumber);
        Integer currentRound = startingNumber.size() + 1;
        Integer previousRoundValue = startingNumber.get(startingNumber.size() - 1);

        while (currentRound.compareTo(maxRound) <= 0) {
            Integer currentValue = Optional.ofNullable(previousRounds.get(previousRoundValue))
                    .filter(previousRoundsOccurences -> previousRoundsOccurences[0] != 0 && previousRoundsOccurences[1] != 0)
                    .map(previousRoundsOccurences -> previousRoundsOccurences[1] - previousRoundsOccurences[0])
                    .orElse(0);

            Integer finalCurrentRound = currentRound;
            Integer[] roundValues = Optional.ofNullable(previousRounds.get(currentValue))
                    .map(previousRoundsOccurences -> {
                        previousRoundsOccurences[0] = previousRoundsOccurences[1];
                        previousRoundsOccurences[1] = finalCurrentRound;
                        return previousRoundsOccurences;
                    })
                    .orElse(new Integer[]{0, currentRound});

            previousRounds.put(currentValue, roundValues);
            previousRoundValue = currentValue;
            currentRound++;
        }

        return previousRounds;
    }

    public static Integer findValueForRound(Integer roundNumber, Map<Integer, Integer[]> previousRounds) {
        return previousRounds.entrySet()
                .stream()
                .filter(entry -> entry.getValue()[0].compareTo(roundNumber) == 0 || entry.getValue()[1].compareTo(
                        roundNumber) == 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }

    @Override
    public Object part1() throws IOException {
        String rawData = readData();
        List<Integer> startingNumbers = Arrays.stream(rawData.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer[]> rounds = playGame(startingNumbers, 2020);
        return findValueForRound(2020, rounds);
    }

    @Override
    public Object part2() throws IOException {
        String rawData = readData();
        List<Integer> startingNumbers = Arrays.stream(rawData.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer[]> rounds = playGame(startingNumbers, 30000000);
        return findValueForRound(30000000, rounds);
    }
}
