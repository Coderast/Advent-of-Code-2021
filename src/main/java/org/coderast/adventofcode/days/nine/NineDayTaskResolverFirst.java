package org.coderast.adventofcode.days.nine;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NineDayTaskResolverFirst extends NineDayTaskResolver {

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var heightmap = input.getHeightmap();

        return getAllLowPoints(heightmap)
                .mapToLong(point -> heightmap[point.getY()][point.getX()])
                .map(height -> height + 1)
                .sum();
    }
}
