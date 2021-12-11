package org.coderast.adventofcode.days.ten;

import com.google.common.collect.ImmutableMap;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Stack;

import static org.coderast.adventofcode.days.ten.Brace.BraceType.*;
import static org.coderast.adventofcode.days.ten.Brace.fromChar;

public class TenDayTaskResolverFirst extends TenDayTaskResolver {
    private static final ImmutableMap<Brace.BraceType, Long> scoreMap = ImmutableMap.<Brace.BraceType, Long>builder()
            .put(Parentheses, 3L)
            .put(Square, 57L)
            .put(Braces, 1197L)
            .put(Brackets, 25137L)
            .build();

    @Override
    @Nonnull
    public Long solve(@Nonnull Input input) {
        return Arrays.stream(input.getLinesWithBraces())
                .filter(line -> line != null && line.length() != 0)
                .map(line -> {
                    final Stack<Brace> bracesStack = new Stack<>();
                    for (final char ch : line.toCharArray()) {
                        final var brace = fromChar(ch);
                        switch (brace.getBraceDirection()) {
                            case Open -> bracesStack.push(brace);
                            case Close -> {
                                if (bracesStack.isEmpty() || brace.getBraceType() != bracesStack.pop().getBraceType()) {
                                    return scoreMap.get(brace.getBraceType());
                                }
                            }
                            default ->
                                throw new IllegalStateException(String.format("Unsupported brace direction %s", brace.getBraceDirection()));
                        }
                    }
                    return 0L;
                })
                .reduce(Long::sum)
                .orElseThrow(()->new IllegalStateException(String.format("Illegal processing of input %s", String.join("\n", input.getLinesWithBraces()))));
    }
}
