package fr.amou.advent.of.code.year2020.days.day18;

import fr.amou.advent.of.code.year2020.Day2020;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

public class Day18 extends Day2020 {

    public Day18() {
        super(18);
    }

    public static void main(String[] args) throws IOException {
        new Day18().printParts();
    }

    public static Double parseExpression(String expression) {
        String replace = expression.replace(" ", "");

        Day18Part1GrammarLexer lexer = new Day18Part1GrammarLexer(CharStreams.fromString(replace));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        Day18Part1GrammarParser parser = new Day18Part1GrammarParser(tokenStream);

        ParseTree tree = parser.expr();

        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new ExpressionListener();

        walker.walk(listener, tree);

        return listener.getResult();
    }

    @Override
    public Object part1() throws IOException {
        List<String> homeworks = readDataAsList();
        Double sum = homeworks
                .stream()
                .map(Day18::parseExpression)
                .reduce(0d, Double::sum);
        return String.format("%.0f", sum);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
