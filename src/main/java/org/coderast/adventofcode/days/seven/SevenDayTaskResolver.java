package org.coderast.adventofcode.days.seven;

import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

public abstract class SevenDayTaskResolver implements TaskResolver<SevenDayTaskResolver.Input, Long> {
    public static class Input {
        private final long[] crabPositions;

        public Input(@Nonnull final long[] crabPositions) {
            this.crabPositions = crabPositions;
        }

        @Nonnull
        public long[] getCrabPositions() {
            return crabPositions;
        }

        @Nonnull
        public static Input withCrabPositions(@Nonnull final long[] crabPositions) {
            return new Input(crabPositions);
        }
    }
}
