package org.coderast.adventofcode.days.one;

import javax.annotation.Nonnull;

public class OneDayTaskResolverFirst extends OneDayTaskResolver {

    @Nonnull
    @Override
    public Long solve(@Nonnull final Input input) {
        var score = 0L;

        var previous = Integer.MAX_VALUE;
        for (final var peeked: input.getMeasurementArray()) {
            score += peeked > previous ? 1 : 0;
            previous = peeked;
        }
        return score;
    }
}
