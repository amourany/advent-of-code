package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day1 extends Day2019 {

    public Day1() {
        super(1);
    }

    public static void main(String[] args) throws IOException {
        new Day1().printParts();
    }

    private static BigDecimal parseMass(String massString) {
        String pattern = "###0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.setParseBigDecimal(true);

        BigDecimal mass = null;
        try {
            mass = (BigDecimal) decimalFormat.parse(massString);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }

        return mass;
    }

    public static BigDecimal computeFuel(BigDecimal mass) {

        BigDecimal massDivided = mass.divide(new BigDecimal(3), RoundingMode.DOWN);
        return massDivided.subtract(new BigDecimal(2));
    }

    public static BigDecimal computeFuelMass(BigDecimal mass) {
        if (mass.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal fuel = computeFuel(mass);

        if (fuel.compareTo(BigDecimal.ZERO) <= 0) {
            fuel = BigDecimal.ZERO;
        }

        return computeFuelMass(fuel).add(fuel);
    }

    @Override
    public Object part1() throws IOException {
        List<String> data = readDataAsList();

        List<BigDecimal> dataProcessed = data.stream()
                .map(Day1::parseMass)
                .map(Day1::computeFuel)
                .collect(Collectors.toList());
        return dataProcessed.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Object part2() throws IOException {
        List<String> data = readDataAsList();

        List<BigDecimal> dataProcessed = data.stream()
                .map(Day1::parseMass)
                .collect(Collectors.toList());

        List<BigDecimal> fuelForFuel = dataProcessed.stream()
                .map(Day1::computeFuelMass)
                .collect(Collectors.toList());
        return fuelForFuel.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
