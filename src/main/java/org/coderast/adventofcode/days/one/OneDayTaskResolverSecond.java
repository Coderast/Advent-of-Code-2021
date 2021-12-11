package org.coderast.adventofcode.days.one;

import javax.annotation.Nonnull;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class OneDayTaskResolverSecond extends OneDayTaskResolver {

    private final int windowWidth;

    public OneDayTaskResolverSecond() {
        this(3);
    }

    public OneDayTaskResolverSecond(final int windowWidth) {
        this.windowWidth = windowWidth;
    }

    private static IntSupplier createIteratorFrom(final Integer[] intArray, final int sinceInclusive) {
        return new IntSupplier() {
            private int iterator = sinceInclusive;
            @Override
            public int getAsInt() {
                return intArray[iterator++];
            }
        };
    }

    private Integer[] applyWindowSmooth(final Integer[] originalMeasurements) {
        final var smoothedMeasurements = new Integer[originalMeasurements.length - this.windowWidth + 1];

        for (int i = 0; i < smoothedMeasurements.length; i++) {
            smoothedMeasurements[i] = IntStream.generate(createIteratorFrom(originalMeasurements, i))
                    .limit(windowWidth)
                    .sum();
        }

        return smoothedMeasurements;
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull final Input input) {
        final var measures = input.getMeasurementArray();
        final var smootherMeasures = applyWindowSmooth(measures);

        var score = 0L;

        var previous = Integer.MAX_VALUE;
        for (final var peeked: smootherMeasures) {
            score += peeked > previous ? 1 : 0;
            previous = peeked;
        }
        return score;
    }
}
