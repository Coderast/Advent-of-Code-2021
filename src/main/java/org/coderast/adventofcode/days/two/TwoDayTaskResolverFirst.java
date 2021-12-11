package org.coderast.adventofcode.days.two;

import javax.annotation.Nonnull;

public class TwoDayTaskResolverFirst extends TwoDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var commands = input.getCommands();

        long horizontalPosition = 0;
        long depth = 0;

        for (final var command : commands) {
            switch (command.getType()) {
                case Forward -> horizontalPosition += command.getAmount();
                case Up -> depth -= command.getAmount();
                case Down -> depth += command.getAmount();
            }
        }

        return horizontalPosition * depth;
    }
}
