package org.coderast.adventofcode.days.eight;

import com.google.common.collect.ImmutableList;
import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

import static org.coderast.adventofcode.days.eight.EightDayTaskResolver.*;

public abstract class EightDayTaskResolver implements TaskResolver<Input, Long> {
    public static class Input {
        private final ImmutableList<ScreenInput> screenInputs;

        public Input(@Nonnull final ImmutableList<ScreenInput> screenInputs) {
            this.screenInputs = screenInputs;
        }

        @Nonnull
        public ImmutableList<ScreenInput> getScreenInputs() {
            return screenInputs;
        }

        @Nonnull
        public static Input withScreenInputs(@Nonnull final ImmutableList<ScreenInput> screenInputs) {
            return new Input(screenInputs);
        }

        public static class ScreenInput {
            private final ImmutableList<String> helpDigits;
            private final ImmutableList<String> outputDigits;

            private ScreenInput(@Nonnull final ImmutableList<String> helpDigits,
                                @Nonnull final ImmutableList<String> outputDigits) {
                this.helpDigits = helpDigits;
                this.outputDigits = outputDigits;
            }

            @Nonnull
            public ImmutableList<String> getHelpDigits() {
                return helpDigits;
            }

            @Nonnull
            public ImmutableList<String> getOutputDigits() {
                return outputDigits;
            }

            @Nonnull
            public static ScreenInput withDigits(@Nonnull final ImmutableList<String> helpDigits,
                                                 @Nonnull final ImmutableList<String> outputDigits) {
                return new ScreenInput(helpDigits, outputDigits);
            }
        }
    }
}
