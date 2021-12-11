package org.coderast.adventofcode.days.two;

import javax.annotation.Nonnull;

public class TwoDayTaskResolverSecond extends TwoDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var commands = input.getCommands();

        long aim = 0;
        long horizontalPosition = 0;
        long depth = 0;

        for (final var command : commands) {
            switch (command.getType()) {
                case Forward -> {
                    horizontalPosition += command.getAmount();
                    depth += command.getAmount() * aim;
                }
                case Up -> aim -= command.getAmount();
                case Down -> aim += command.getAmount();
            }
        }

        return horizontalPosition * depth;
    }
}
