package fr.amou.advent.of.code.year2020.days.day18;

import fr.amou.advent.of.code.year2020.days.day18.Day18Part1GrammarParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static fr.amou.advent.of.code.year2020.days.day18.Day18Part1GrammarParser.*;

public class ExpressionListenerPart1 extends Day18Part1GrammarBaseListener {

    private final Deque<Double> argStack = new ArrayDeque<>();
    private final Deque<Integer> opStack = new ArrayDeque<>();

    public double getResult() {
        return this.argStack.pop();
    }

    @Override
    public void exitExpression(final ExpressionContext ctx) {
        handleExpression(ctx);
    }

    @Override
    public void exitExpr(final ExprContext ctx) {
        handleExpression(ctx);
    }

    @Override
    public void visitTerminal(final TerminalNode node) {
        final Token symbol = node.getSymbol();
        final int type = symbol.getType();
        switch (type) {
            case NUMBER:
                this.argStack.push(Double.valueOf(symbol.getText()));
                break;
            case MULTIPLICATION:
            case ADDITION:
                this.opStack.push(type);
                break;
            default:
                break;
        }
    }

    private void handleExpression(final ParserRuleContext ctx) {
        if (ctx.getChildCount() == 3) { // Operations have 3 children
            final double right = this.argStack.pop();
            final double left = this.argStack.pop();
            final int op = this.opStack.pop();
            switch (op) {
                case MULTIPLICATION:
                    this.argStack.push(left * right);
                    break;
                case ADDITION:
                    this.argStack.push(left + right);
                    break;
                default:
                    break;
            }
        }
    }
}
