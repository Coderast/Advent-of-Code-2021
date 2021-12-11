package org.coderast.adventofcode.days.ten;

import com.google.common.collect.ImmutableMap;

import javax.annotation.Nonnull;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

import static org.coderast.adventofcode.days.ten.Brace.BraceType.*;
import static org.coderast.adventofcode.days.ten.Brace.BraceType.Brackets;
import static org.coderast.adventofcode.days.ten.Brace.fromChar;

public class TenDayTaskResolverSecond extends TenDayTaskResolver {
    private static final ImmutableMap<Brace.BraceType, Integer> scoreMap = ImmutableMap.<Brace.BraceType, Integer>builder()
            .put(Parentheses, 1)
            .put(Square, 2)
            .put(Braces, 3)
            .put(Brackets, 4)
            .build();

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var scoresArray = Arrays.stream(input.getLinesWithBraces())
                .filter(line -> line != null && line.length() != 0)
                .map(line -> {
                    final Stack<Brace> bracesStack = new Stack<>();
                    for (final char ch : line.toCharArray()) {
                        final var brace = fromChar(ch);
                        switch (brace.getBraceDirection()) {
                            case Open -> bracesStack.push(brace);
                            case Close -> {
                                if (bracesStack.isEmpty() || brace.getBraceType() != bracesStack.pop().getBraceType()) {
                                    return 0L;
                                }
                            }
                            default -> throw new IllegalStateException(String.format("Unsupported brace direction %s", brace.getBraceDirection()));
                        }
                    }

                    long score = 0;
                    while (!bracesStack.isEmpty()) {
                        score *= 5;
                        score += Optional.of(bracesStack.pop())
                                .map(Brace::getBraceType)
                                .map(scoreMap::get)
                                .orElseThrow();
                    }

                    return score;
                })
                .filter(score -> score > 0)
                .sorted()
                .toArray(Long[]::new);
        return scoresArray[scoresArray.length / 2];
    }


}
