package fr.amou.advent.of.code.days;

import fr.amou.advent.of.code.common.Day;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fr.amou.advent.of.code.utils.DataReader.readDataAsListForDay;

@Log4j2
public class Day2 implements Day {

    public static void main(String[] args) throws IOException {
        Day day = new Day2();
        day.part1();
        day.part2();
    }

    public static long countValidPasswords(List<String> passwords, Function<PasswordPolicy, Boolean> passwordVerifier) {
        return passwords.stream()
                .map(PasswordPolicy::new)
                .map(passwordVerifier)
                .filter(b -> b)
                .count();
    }

    public static boolean checkPasswordPart1(PasswordPolicy passwordPolicy) {
        long foundOccurences = passwordPolicy.getPassword()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.equals(passwordPolicy.getCharacterToCheck()))
                .count();

        return foundOccurences >= passwordPolicy.getMinOccurence() && foundOccurences <= passwordPolicy.getMaxOccurence();
    }

    public static Boolean checkPasswordPart2(PasswordPolicy passwordPolicy) {
        String password = passwordPolicy.getPassword();
        int firstPosition = passwordPolicy.getMinOccurence() - 1;
        int secondPosition = passwordPolicy.getMaxOccurence() - 1;
        char characterToCheck = passwordPolicy.getCharacterToCheck();

        return password.charAt(firstPosition) == characterToCheck ^ password.charAt(secondPosition) == characterToCheck;
    }

    @Override
    public void part1() throws IOException {
        List<String> passwordPolicies = readDataAsListForDay(2);
        long validPasswords = countValidPasswords(passwordPolicies, Day2::checkPasswordPart1);
        log.info("  Part 1: {}", validPasswords);
    }

    @Override
    public void part2() throws IOException {
        List<String> passwordPolicies = readDataAsListForDay(2);
        long validPasswords = countValidPasswords(passwordPolicies, Day2::checkPasswordPart2);
        log.info("  Part 2: {}", validPasswords);
    }

    @Getter
    public static class PasswordPolicy {

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
    }
}
