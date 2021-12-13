package org.coderast.adventofcode.days.seven;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SevenDayTaskResolverSecond extends SevenDayTaskResolver {
    private static long calculateSumOfFuel(@Nonnull final long[] positions, final long position) {
        return Arrays.stream(positions)
                .map(number -> {
                    final var dx = Math.abs(number - position);
                    return (dx * (dx + 1)) / 2;
                })
                .sum();
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var numbers = input.getCrabPositions();

        final var min = Arrays.stream(numbers).min().orElseThrow();
        final var max = Arrays.stream(numbers).max().orElseThrow();

        return Stream.generate(new Supplier<Long>() {
            long start = min;
            @Override
            public Long get() {
                return start++;
            }
        }).limit(max-min+1).mapToLong(number -> calculateSumOfFuel(numbers, number)).min().orElseThrow();
    }
}
