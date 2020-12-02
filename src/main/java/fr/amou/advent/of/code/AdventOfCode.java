package fr.amou.advent.of.code;

import fr.amou.advent.of.code.common.Day;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.IntStream;

@Log4j2
public class AdventOfCode {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 2)
                .boxed()
                .forEach(day -> {
                    log.info("Day {}:", day);
                    try {
                        Day instance = (Day) Class.forName("fr.amou.advent.of.code.days.Day" + day)
                                .getDeclaredConstructor()
                                .newInstance();
                        instance.part1();
                        instance.part2();
                        log.info("\n");
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | IOException e) {
                        log.error(e.getMessage(), e);
            }
        });
    }
}
