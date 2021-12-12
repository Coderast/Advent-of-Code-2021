package org.coderast.adventofcode.days.eight;

import javax.annotation.Nonnull;

public class EightDayTaskResolverFirst extends EightDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        return input.getScreenInputs().stream()
                .map(Input.ScreenInput::getOutputDigits)
                .mapToLong(outputDigits -> outputDigits.stream()
                        .filter(digit -> digit.length() == 2 || digit.length() == 4 || digit.length() == 3 || digit.length() == 7)
                        .count())
                .sum();
    }
}
