package fr.amou.advent.of.code.year2020.days.day14;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.ToLongFunction;
import java.util.regex.Pattern;

public interface DecoderChip {

    Pattern INSTRUCTION_PATTERN = Pattern.compile("^mem\\[([0-9]*)] = ([0-9]*)$");

    IntFunction<String> convertBase10ToBase2 = base10Value -> StringUtils.leftPad(
            Integer.toBinaryString(base10Value), 36, "0");
    ToLongFunction<String> convertBase2ToBase10 = base2Value -> Long.parseLong(base2Value, 2);

    Map<? extends Number, String> decode(List<String> instructionsAndMasks);

    Long sumMemoryValues(Map<? extends Number, String> memory);
}
