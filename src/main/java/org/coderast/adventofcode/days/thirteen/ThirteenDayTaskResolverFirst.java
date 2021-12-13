package org.coderast.adventofcode.days.thirteen;

import org.coderast.adventofcode.days.nine.Point;

import javax.annotation.Nonnull;

public class ThirteenDayTaskResolverFirst extends ThirteenDayTaskResolver {


    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var dots = input.getPoints();
        final var firstFolding = input.getFoldings().get(0);

        final var countNotOverlapped = dots.stream()
                .filter(dot -> !dots.contains(getMirrored(dot, firstFolding)))
                .count();

        return dots.size() - (dots.size() - countNotOverlapped) / 2;
    }
}
