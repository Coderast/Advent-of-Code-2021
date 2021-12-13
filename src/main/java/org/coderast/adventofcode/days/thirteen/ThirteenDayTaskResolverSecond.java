package org.coderast.adventofcode.days.thirteen;

import com.google.common.collect.ImmutableSet;
import org.coderast.adventofcode.days.nine.Point;

import javax.annotation.Nonnull;
import java.util.Comparator;

public class ThirteenDayTaskResolverSecond extends ThirteenDayTaskResolver {

    ImmutableSet<Point> turnRound(final ImmutableSet<Point> dots, final Input.Folding folding) {
        final var result = ImmutableSet.<Point>builder();

        for (final var dot : dots) {
            final var mirrored = getMirrored(dot, folding);
            if (dot.getX() < mirrored.getX() || dot.getY() < mirrored.getY()) {
                result.add(dot);
            } else {
                result.add(mirrored);
            }
        }

        return result.build();
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        var dots = input.getPoints();
        final var foldings = input.getFoldings();

        for (final var folding : foldings) {
            dots = turnRound(dots, folding);
        }

        final var maxX = dots.stream().mapToInt(Point::getX).max().orElseThrow();
        final var maxY = dots.stream().mapToInt(Point::getY).max().orElseThrow();

        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                System.out.print(dots.contains(Point.of(x, y)) ? "#" : ".");
            }
            System.out.println();
        }

        return 0L;
    }
}
