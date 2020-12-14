package fr.amou.advent.of.code.year2020.days.day14;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;

public class DecoderChipV1 implements DecoderChip {

    @Override
    public Map<Integer, String> decode(List<String> instructionsAndMasks) {
        Map<Integer, String> memory = new HashMap<>();

        for (String instructionsAndMask : instructionsAndMasks) {

            String[] instructionsAndMaskSplit = instructionsAndMask.split(DEFAULT_DELIMITER);
            Mask mask = new Mask(instructionsAndMaskSplit[0]);

            IntStream.range(1, instructionsAndMaskSplit.length)
                    .boxed()
                    .forEach(index -> {

                        Matcher matcher = INSTRUCTION_PATTERN.matcher(instructionsAndMaskSplit[index]);
                        matcher.find();
                        Integer memoryIndex = Integer.parseInt(matcher.group(1));
                        Integer base10Value = Integer.parseInt(matcher.group(2));

                        String base2Value = convertBase10ToBase2.apply(base10Value);
                        memory.put(memoryIndex, applyMask(base2Value, mask));
                    });
        }

        return memory;
    }

    @Override
    public Long sumMemoryValues(Map<? extends Number, String> memory) {
        return memory.values()
                .stream()
                .map(convertBase2ToBase10::applyAsLong)
                .reduce(0L, Math::addExact);
    }

    private String applyMask(String base2Value, Mask mask) {
        return IntStream.range(0, base2Value.length())
                .boxed()
                .map(index -> Optional.ofNullable(mask.getMask()
                        .get(index))
                        .filter(bitmask -> !StringUtils.equals(bitmask, "X"))
                        .orElse(String.valueOf(base2Value.charAt(index))))
                .reduce("", String::concat);
    }
}
