package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface TaskResolver<INPUT, RESULT> {
    @Nonnull
    RESULT solve(@Nonnull INPUT input);
}
