package fr.amou.advent.of.code.days;

import fr.amou.advent.of.code.common.Day;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fr.amou.advent.of.code.utils.DataReader.readDataForDay;

@Log4j2
public class Day2 implements Day {

    public static void main(String[] args) throws IOException {

        Day day = new Day2();
        day.part1();
    }

    public static long countValidPasswords(List<String> passwords) {
        return passwords.stream()
                .map(PasswordPolicy::new)
                .map(PasswordPolicy::verifyPassword)
                .filter(b -> b)
                .count();
    }

    @Override
    public void part1() throws IOException {
        List<String> passwordPolicies = List.of(readDataForDay(2).split("\n"));
        long validPasswords = countValidPasswords(passwordPolicies);
        log.info(validPasswords);
    }

    @Override
    public void part2() throws IOException {

    }

    private static class PasswordPolicy {

        private final char characterToCheck;
        private final int minOccurence;
        private final int maxOccurence;
        private final String password;

        public PasswordPolicy(String passwordPolicy) {

            Pattern passwordPolicyPattern = Pattern.compile("([0-9]*)-([0-9]*) ([a-z]): ([a-z]*)");
            Matcher matcher = passwordPolicyPattern.matcher(passwordPolicy);
            matcher.find();

            minOccurence = Integer.parseInt(matcher.group(1));
            maxOccurence = Integer.parseInt(matcher.group(2));
            characterToCheck = matcher.group(3)
                    .charAt(0);
            password = matcher.group(4);
        }

        public boolean verifyPassword() {
            long foundOccurences = password.chars()
                    .mapToObj(c -> (char) c)
                    .filter(c -> c.equals(characterToCheck))
                    .count();

            return foundOccurences >= minOccurence && foundOccurences <= maxOccurence;
        }
    }
}
