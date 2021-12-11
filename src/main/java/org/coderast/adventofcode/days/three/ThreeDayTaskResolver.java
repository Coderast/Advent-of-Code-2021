package org.coderast.adventofcode.days.three;

import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

public abstract class ThreeDayTaskResolver implements TaskResolver<ThreeDayTaskResolver.Input, Long> {
    public static class Input {
        private final char[][] numbersMatrix;

        public Input(char[][] numbersMatrix) {
            this.numbersMatrix = numbersMatrix;
        }

        public char[][] getNumbersMatrix() {
            return numbersMatrix;
        }

        @Nonnull
        public static Input withRawBinaryNumbers(@Nonnull final char[][] numbersMatrix) {
            return new Input(numbersMatrix);
        }
    }
}
