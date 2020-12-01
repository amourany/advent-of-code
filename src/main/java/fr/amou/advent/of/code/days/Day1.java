package fr.amou.advent.of.code.days;

import fr.amou.advent.of.code.common.Day;
import fr.amou.advent.of.code.utils.DataReader;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log4j2
public class Day1 implements Day {

    public static void main(String[] args) throws IOException {
        Day day = new Day1();
        day.part1();
    }

    public static int fixExpenseReport(List<Integer> expenseReport) {
        return expenseReport.stream()
                            .filter(entry -> entry <= 2020)
                            .map(firstEntry -> {
                                Optional<Integer> optionalSecondEntry = findSecondEntry(expenseReport, firstEntry);
                                return optionalSecondEntry.map(secondEntry -> firstEntry * secondEntry);
                            })
                            .filter(Optional::isPresent)
                            .findFirst()
                            .get()
                            .get();
    }

    private static Optional<Integer> findSecondEntry(List<Integer> expenseReport, int firstEntry) {
        return expenseReport.stream()
                            .filter(secondEntry -> firstEntry + secondEntry == 2020)
                            .findFirst();
    }

    @Override
    public void part1() throws IOException {
        List<Integer> part1Input = DataReader.readDataAsIntegerForDay(1);
        int result = fixExpenseReport(part1Input);
        log.info("Part 1: {}", result);
    }

    @Override
    public void part2() {

    }
}
