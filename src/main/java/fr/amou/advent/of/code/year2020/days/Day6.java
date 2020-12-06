package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;

public class Day6 extends Day2020 {

    public Day6() {
        super(6);
    }

    public static void main(String[] args) throws IOException {
        new Day6().printParts();
    }

    public static Integer countYesAnswerInGroup(List<String> groupAnswers) {
        return groupAnswers.stream()
                .map(answer -> answer.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Object part1() throws IOException {
        String data = readData();
        List<List<String>> groupAnswers = Arrays.stream(data.split(DEFAULT_DELIMITER + DEFAULT_DELIMITER))
                .map(rawGroupAnswer -> Arrays.stream(rawGroupAnswer.split(DEFAULT_DELIMITER))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        return groupAnswers.stream()
                .map(Day6::countYesAnswerInGroup)
                .reduce(0, Math::addExact);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
