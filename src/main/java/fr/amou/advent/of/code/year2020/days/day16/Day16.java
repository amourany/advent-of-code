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
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.common.DataReader.DEFAULT_DELIMITER;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.List.of;
import static java.util.Map.Entry;
import static java.util.Map.entry;
import static java.util.stream.Collectors.toList;
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
                    return entry(field, of(between(parseInt(range1[0]), parseInt(range1[1])),
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

    public static List<List<Integer>> removeInvalidTickets(List<String> nearbyTickets,
                                                           Map<String, List<Range<Integer>>> ruleSet) {
        List<Range<Integer>> allRules = ruleSet.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return nearbyTickets.stream()
                .map(ticket -> Arrays.stream(ticket.split(","))
                        .map(Integer::parseInt)
                        .collect(toList()))
                .filter(oneTicket -> oneTicket.stream()
                        .allMatch(value -> allRules.stream()
                                .anyMatch(range -> range.contains(value))))
                .collect(toList());
    }

    public static Map<String, Integer> deduceFieldsOrder(List<List<Integer>> validTickets,
                                                         Map<String, List<Range<Integer>>> ruleSet) {
        Integer maxPosition = ruleSet.size();
        Map<String, List<Integer>> fieldPositions = ruleSet.keySet()
                .stream()
                .map(field -> Map.entry(field, generateFieldsPossiblePositions(maxPosition)))
                .collect(toMap(Entry::getKey, Entry::getValue));

        validTickets.forEach(ticket -> IntStream.range(0, ticket.size())
                .boxed()
                .forEach(index -> ruleSet.forEach((key, value) -> {
                    if (value.stream()
                            .noneMatch(range -> range.contains(ticket.get(index)))) {
                        fieldPositions.get(key)
                                .remove(index);
                    }
                })));

        reducePossiblePositions(fieldPositions);

        return fieldPositions.entrySet()
                .stream()
                .collect(toMap(Entry::getKey, entry -> entry.getValue()
                        .get(0)));
    }

    private static Map<String, List<Integer>> reducePossiblePositions(Map<String, List<Integer>> possiblePositions) {
        while (!possiblePositions.values()
                .stream()
                .allMatch(value -> value.size() == 1)) {
            List<Integer> positionFound = possiblePositions.values()
                    .stream()
                    .filter(entry -> entry.size() == 1)
                    .flatMap(List::stream)
                    .collect(toList());

            possiblePositions.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue()
                            .size() != 1)
                    .forEach(entry -> entry.getValue()
                            .removeAll(positionFound));
        }

        return possiblePositions;
    }

    private static List<Integer> generateFieldsPossiblePositions(Integer maxPosition) {
        return IntStream.range(0, maxPosition)
                .boxed()
                .collect(toList());
    }

    private static Long findValuesForDepartureFields(Map<String, Integer> fieldsOrder, List<Integer> myTicket) {
        return fieldsOrder.entrySet()
                .stream()
                .filter(entry -> entry.getKey()
                        .contains("departure"))
                .map(Entry::getValue)
                .map(myTicket::get)
                .map(Integer::longValue)
                .reduce(1L, Math::multiplyExact);
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
        String notes = readData();
        String[] notesParts = notes.split(DEFAULT_DELIMITER + DEFAULT_DELIMITER);
        Map<String, List<Range<Integer>>> ruleSet = buildRuleSet(asList(notesParts[0].split(DEFAULT_DELIMITER)));

        List<String> nearbyTickets = asList(notesParts[2].split(DEFAULT_DELIMITER));
        List<List<Integer>> validTickets = removeInvalidTickets(
                nearbyTickets.subList(1, nearbyTickets.size()), ruleSet);
        Map<String, Integer> fieldsOrder = deduceFieldsOrder(validTickets, ruleSet);
        List<Integer> myTicket = Arrays.stream(notesParts[1].split(DEFAULT_DELIMITER)[1].split(","))
                .map(Integer::parseInt)
                .collect(toList());
        return findValuesForDepartureFields(fieldsOrder, myTicket);
    }
}
