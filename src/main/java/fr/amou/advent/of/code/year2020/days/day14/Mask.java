package fr.amou.advent.of.code.year2020.days.day14;

import lombok.Getter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.entry;

public class Mask {

    @Getter
    private final Map<Integer, String> mask;

    public Mask(String maskDefinition) {
        String[] maskArray = maskDefinition.split("");
        mask = IntStream.range(0, maskArray.length)
                .filter(index -> !maskArray[index].equals("X"))
                .mapToObj(index -> entry(index, maskArray[index]))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
}
