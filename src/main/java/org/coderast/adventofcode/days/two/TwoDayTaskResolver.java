package org.coderast.adventofcode.days.two;

import com.google.common.collect.ImmutableList;
import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

import static org.coderast.adventofcode.days.two.TwoDayTaskResolver.*;

public abstract class TwoDayTaskResolver implements TaskResolver<Input, Long> {
    public static class Input {
        private final ImmutableList<Command> commands;

        private Input(ImmutableList<Command> commands) {
            this.commands = commands;
        }

        public ImmutableList<Command> getCommands() {
            return commands;
        }

        @Nonnull
        public static Input withCommands(@Nonnull final Iterable<Command> commands) {
            return new Input(ImmutableList.copyOf(commands));
        }
    }
}
