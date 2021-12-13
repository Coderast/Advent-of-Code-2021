package org.coderast.adventofcode.days.seven;

import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SevenDayTaskResolverFirst extends SevenDayTaskResolver {

    private static long calculateSumOfFuel(@Nonnull final long[] positions, final long position) {
        return Arrays.stream(positions)
                .map(number -> Math.abs(number - position))
                .sum();
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var numbers = input.getCrabPositions();

        return Arrays.stream(numbers).map(number -> calculateSumOfFuel(numbers, number)).min().orElseThrow();
    }
}
