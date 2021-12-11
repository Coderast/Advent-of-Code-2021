package org.coderast.adventofcode.days.ten;

import org.coderast.adventofcode.resolving.TaskResolver;

import static org.coderast.adventofcode.days.ten.TenDayTaskResolver.*;

public abstract class TenDayTaskResolver implements TaskResolver<Input, Long> {
    public static class Input {
        private final String[] linesWithBraces;

        private Input(String[] linesWithBraces) {
            this.linesWithBraces = linesWithBraces;
        }

        public String[] getLinesWithBraces() {
            return linesWithBraces;
        }

        public static Input withLines(final String[] linesWithBraces) {
            return new Input(linesWithBraces);
        }
    }
}
