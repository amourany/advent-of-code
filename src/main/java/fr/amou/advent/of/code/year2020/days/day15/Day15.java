package fr.amou.advent.of.code.year2020.days.day15;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day15 extends Day2020 {

    public Day15() {
        super(15);
    }

    public static void main(String[] args) throws IOException {
        new Day15().printParts();
    }

    public static Map<Integer, Integer> playStartingRounds(List<Integer> startingNumbers) {
        return IntStream.range(0, startingNumbers.size())
                .mapToObj(roundNumber -> Map.entry(roundNumber + 1, startingNumbers.get(roundNumber)))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<Integer, Integer> playNextRound(Integer currentRound, Integer maxRound,
                                                      Map<Integer, Integer> previousRounds) {
        if (currentRound.compareTo(maxRound) > 0) {
            return previousRounds;
        }

        Integer previousRoundValue = previousRounds.get(currentRound - 1);
        List<Entry<Integer, Integer>> previousOccurencesOfNumber = previousRounds.entrySet()
                .stream()
                .filter(entry -> entry.getValue()
                        .compareTo(previousRoundValue) == 0)
                .sorted(Entry.<Integer, Integer>comparingByKey().reversed())
                .collect(Collectors.toList());

        Integer currentValue = previousOccurencesOfNumber.size() == 1 ? 0 : previousOccurencesOfNumber.get(0)
                .getKey() - previousOccurencesOfNumber.get(1)
                .getKey();

        previousRounds.put(currentRound, currentValue);

        return playNextRound(currentRound + 1, maxRound, previousRounds);
    }

    @Override
    public Object part1() throws IOException {
        String rawData = readData();
        List<Integer> startingNumbers = Arrays.stream(rawData.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<Integer, Integer> startingRounds = playStartingRounds(startingNumbers);
        Map<Integer, Integer> nextRounds = playNextRound(startingNumbers.size() + 1, 2020, startingRounds);
        return nextRounds.get(2020);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
