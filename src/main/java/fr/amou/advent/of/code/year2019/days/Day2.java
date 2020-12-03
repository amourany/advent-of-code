package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.common.DataReader;
import fr.amou.advent.of.code.year2019.Day2019;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day2 extends Day2019 {

    public Day2() {
        super(2);
    }

    public static void main(String[] args) throws IOException {
        new Day2().printParts();
    }

    private static List<Integer> initMemory() throws IOException {
        String dataStringList = DataReader.readData(2019, 2);
        return Arrays.stream(dataStringList.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> computeInstructions(List<Integer> dataIntegerList) {

        for (int i = 0; i < dataIntegerList.size(); i++) {
            Integer currentInstruction = dataIntegerList.get(i);

            if (currentInstruction == 1) {
                Integer pos1 = dataIntegerList.get(++i);
                Integer val1 = dataIntegerList.get(pos1);
                Integer pos2 = dataIntegerList.get(++i);
                Integer val2 = dataIntegerList.get(pos2);
                Integer storeLocation = dataIntegerList.get(++i);

                dataIntegerList.set(storeLocation, val1 + val2);
            }

            if (currentInstruction == 2) {
                Integer pos1 = dataIntegerList.get(++i);
                Integer val1 = dataIntegerList.get(pos1);
                Integer pos2 = dataIntegerList.get(++i);
                Integer val2 = dataIntegerList.get(pos2);
                Integer storeLocation = dataIntegerList.get(++i);

                dataIntegerList.set(storeLocation, val1 * val2);
            }

            if (currentInstruction == 99) {
                i = dataIntegerList.size();
            }
        }

        return dataIntegerList;
    }

    @Override
    public Object part1() throws IOException {
        List<Integer> dataIntegerList = initMemory();

        dataIntegerList.set(1, 12);
        dataIntegerList.set(2, 2);

        List<Integer> dataProcessed = Day2.computeInstructions(dataIntegerList);

        return dataProcessed.get(0);
    }

    @Override
    public Object part2() throws IOException {

        Integer goal = 19690720;

        Integer answer = 0;
        Integer finalAnswer = 0;

        for (int noun = 0; noun < 100 || answer.equals(goal); noun++) {
            for (int verb = 0; verb < 100 || answer.equals(goal); verb++) {

                List<Integer> dataIntegerList = initMemory();

                dataIntegerList.set(1, noun);
                dataIntegerList.set(2, verb);

                List<Integer> dataProcessed = Day2.computeInstructions(dataIntegerList);
                answer = dataProcessed.get(0);

                if (answer.equals(goal)) {
                    log.info("Goal reached - noun : {}, verb : {}, solution : {}", noun, verb, 100 * noun + verb);
                    finalAnswer = 100 * noun + verb;
                }
            }
        }

        return finalAnswer;
    }
}
