package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface InputParser<INTERNAL> {
    @Nonnull
    INTERNAL parse(@Nonnull String raw);
}
