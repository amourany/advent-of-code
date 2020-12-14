package fr.amou.advent.of.code.year2020.days.day14;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DecoderChipV2 implements DecoderChip {

    private static List<String> computeAllMemoryAddresses(String memoryAndMask) {

        String firstDigit = String.valueOf(memoryAndMask.charAt(0));
        List<String> permutations = StringUtils.equals(firstDigit, "X") ? List.of("0", "1") : List.of(firstDigit);

        if (memoryAndMask.length() == 1) {
            return permutations;
        }

        return permutations.stream()
                .map(digit -> computeAllMemoryAddresses(memoryAndMask.substring(1)).stream()
                        .map(nextValues -> digit + nextValues)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static String applyMask(String memory, Mask mask) {
        return IntStream.range(0, memory.length())
                .mapToObj(index -> Optional.ofNullable(mask.getMask()
                        .get(index))
                        .filter(bitmask -> !StringUtils.equals(bitmask, "0"))
                        .orElse(String.valueOf(memory.charAt(index))))
                .reduce(EMPTY, String::concat);
    }

    @Override
    public Map<Long, String> decode(List<String> instructionsAndMasks) {
        Map<Long, String> memory = new HashMap<>();

        for (String instructionsAndMask : instructionsAndMasks) {

            String[] instructionsAndMaskSplit = instructionsAndMask.split(DEFAULT_DELIMITER);
            Mask mask = new Mask(instructionsAndMaskSplit[0]);

            IntStream.range(1, instructionsAndMaskSplit.length)
                    .boxed()
                    .forEach(index -> {

                        Matcher matcher = INSTRUCTION_PATTERN.matcher(instructionsAndMaskSplit[index]);
                        matcher.find();
                        String memoryIndex = convertBase10ToBase2.apply(Integer.parseInt(matcher.group(1)));
                        Integer base10Value = Integer.parseInt(matcher.group(2));

                        String memoryAndMask = applyMask(memoryIndex, mask);
                        List<String> resolvedMemoryAddresses = computeAllMemoryAddresses(memoryAndMask);

                        resolvedMemoryAddresses.forEach(address -> memory.put(convertBase2ToBase10.applyAsLong(address),
                                base10Value.toString()));
                    });
        }

        return memory;
    }

    @Override
    public Long sumMemoryValues(Map<? extends Number, String> memory) {
        return memory.values()
                .stream()
                .map(s -> Long.parseLong(s, 10))
                .reduce(0L, Math::addExact);
    }
}
