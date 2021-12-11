package org.coderast.adventofcode.days.eleven;

import javax.annotation.Nonnull;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ElevenDayTaskResolverSecond extends ElevenDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var octopusMatrix = input.getOctopusMatrix().clone();

        return LongStream.generate(new LongSupplier() {
            long i = 1;
            @Override
            public long getAsLong() {
                return i++;
            }
        })
                .filter(i -> turnRound(octopusMatrix) == (long) octopusMatrix.length * octopusMatrix[0].length)
                .findFirst()
                .getAsLong();
    }
}
