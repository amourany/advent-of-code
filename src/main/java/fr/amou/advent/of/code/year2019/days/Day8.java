package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 extends Day2019 {

    public static final Integer LAYER_SIZE = 25 * 6;

    public Day8() {
        super(8);
    }

    public static void main(String[] args) throws IOException {
        new Day8().printParts();
    }

    public static List<String> splitDataToLayers(String imageData, Integer layerSize) {
        return Arrays.stream(imageData.split("(?<=\\G.{" + layerSize + "})"))
                .collect(Collectors.toList());
    }

    public static String findLayerWithFewest0Digit(List<String> imageLayers) {
        return imageLayers.stream()
                .reduce((layer1, layer2) -> countDigit(layer1, '0') < countDigit(layer2, '0') ? layer1 : layer2)
                .get();
    }

    private static Long countDigit(String layer, Character digitToFind) {
        return layer.chars()
                .mapToObj(c -> (char) c)
                .filter(digit -> digit.equals(digitToFind))
                .count();
    }

    @Override
    public Object part1() throws IOException {
        String imageData = readData();
        List<String> layers = Day8.splitDataToLayers(imageData, LAYER_SIZE);

        String layerWithFewest0 = findLayerWithFewest0Digit(layers);
        Long nbOf1 = countDigit(layerWithFewest0, '1');
        Long nbOf2 = countDigit(layerWithFewest0, '2');

        return nbOf1 * nbOf2;
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
