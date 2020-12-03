package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public class Day4 extends Day2019 {

    public Day4() {
        super(4);
    }

    public static void main(String[] args) throws IOException {
        new Day4().printParts();
    }

    public static Boolean isPasswordValid(Integer password) {

        List<String> digits = Arrays.asList(password.toString()
                .split(""));

        Boolean hasTwoAdjacent = false;
        Boolean foundOnce = false;
        String previousDigit = "";
        for (int i = 0; i < digits.size() - 1; i++) {
            String currentDigit = digits.get(i);

            if (currentDigit.equals(digits.get(i + 1))) {

                hasTwoAdjacent = !hasTwoAdjacent || !currentDigit.equals(previousDigit);
            }

            if ((!currentDigit.equals(digits.get(i + 1)) || i + 2 >= digits.size()) && hasTwoAdjacent) {
                foundOnce = true;
            }
            previousDigit = digits.get(i);
        }

        AtomicReference<Boolean> neverDecrease = new AtomicReference<>(true);
        AtomicReference<Integer> max = new AtomicReference<>(0);

        digits.stream()
                .map(Integer::parseInt)
                .peek(digit -> {
                    if (digit < max.get()) {
                        neverDecrease.set(false);
                    } else if (digit > max.get()) {
                        max.set(digit);
                    }
                })
                .collect(Collectors.toList());

        Boolean isValid = foundOnce && neverDecrease.get();
        return isValid;
    }

    @Override
    public Object part1() throws IOException {
        List<Boolean> validPasswords = IntStream.rangeClosed(372037, 905157)
                .boxed()
                .map(Day4::isPasswordValid)
                .filter(isValid -> isValid)
                .collect(Collectors.toList());

        return validPasswords.size();
    }

    @Override
    public Object part2() throws IOException {
        List<Boolean> validPasswords = IntStream.rangeClosed(372037, 905157)
                .boxed()
                .map(Day4::isPasswordValid)
                .filter(isValid -> isValid)
                .collect(Collectors.toList());

        return validPasswords.size();
    }
}
