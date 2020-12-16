package fr.amou.advent.of.code.year2020.days.day16;

import fr.amou.advent.of.code.year2020.Day2020;
import org.apache.commons.lang3.Range;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.List.of;
import static java.util.Map.Entry;
import static java.util.Map.entry;
import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.Range.between;

public class Day16 extends Day2020 {

    private static final Pattern RULES_PATTERN = Pattern.compile("^([a-z ]*): ([0-9-]*) or ([0-9-]*)$");

    public Day16() {
        super(16);
    }

    public static void main(String[] args) throws IOException {
        new Day16().printParts();
    }

    private static Map<String, List<Range<Integer>>> buildRuleSet(List<String> rules) {
        return rules.stream()
                .map(rule -> {
                    Matcher matcher = RULES_PATTERN.matcher(rule);
                    matcher.find();
                    String field = matcher.group(1);
                    String[] range1 = matcher.group(2)
                            .split("-");
                    String[] range2 = matcher.group(3)
                            .split("-");
                    return entry(field, of(
                            between(parseInt(range1[0]), parseInt(range1[1])),
                            between(parseInt(range2[0]), parseInt(range2[1]))));
                })
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    public static List<Integer> findInvalidValues(List<String> nearbyTickets,
                                                  Map<String, List<Range<Integer>>> ruleSet) {
        List<Range<Integer>> allRules = ruleSet.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return nearbyTickets.stream()
                .flatMap(ticket -> Arrays.stream(ticket.split(",")))
                .map(Integer::parseInt)
                .filter(ticketValue -> allRules.stream()
                        .noneMatch(range -> range.contains(ticketValue)))
                .collect(Collectors.toList());
    }

    public static Integer computeTicketScanningErrorRate(String notes) {
        String[] notesParts = notes.split(DEFAULT_DELIMITER + DEFAULT_DELIMITER);
        Map<String, List<Range<Integer>>> ruleSet = buildRuleSet(asList(notesParts[0].split(DEFAULT_DELIMITER)));

        List<String> nearbyTickets = asList(notesParts[2].split(DEFAULT_DELIMITER));
        List<Integer> invalidValues = findInvalidValues(nearbyTickets.subList(1, nearbyTickets.size()), ruleSet);
        return invalidValues.stream()
                .reduce(0, Math::addExact);
    }

    @Override
    public Object part1() throws IOException {
        String notes = readData();
        return computeTicketScanningErrorRate(notes);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
