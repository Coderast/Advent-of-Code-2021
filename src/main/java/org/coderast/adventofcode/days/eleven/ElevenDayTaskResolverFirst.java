package org.coderast.adventofcode.days.eleven;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ElevenDayTaskResolverFirst extends ElevenDayTaskResolver {
    private static void printMatrix(final int[][] matrix, final int step) {
        System.out.printf("====== Matrix [%d] ======%n", step);

        for (final var line : matrix) {
            for (final var cell: line) {
                System.out.print(cell);
            }
            System.out.print("\n");
        }

        System.out.println("==========================\n\n");
    }


    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var octopusMatrix = input.getOctopusMatrix().clone();

        return Stream.generate(() -> turnRound(octopusMatrix))
                .limit(100)
                .mapToLong(score -> score)
                .sum();
    }
}
