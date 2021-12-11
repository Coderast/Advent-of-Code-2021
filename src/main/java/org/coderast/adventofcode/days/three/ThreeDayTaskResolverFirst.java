package org.coderast.adventofcode.days.three;

import javax.annotation.Nonnull;

public class ThreeDayTaskResolverFirst extends ThreeDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final char[][] numbersMatrix = input.getNumbersMatrix();

        final int numberCount = numbersMatrix.length;
        final int numberLength = numbersMatrix[0].length;

        long gamma = 0;
        for (int digitId = 0; digitId < numberLength; digitId++) {
            int countOfOnes = 0;
            for (char[] number : numbersMatrix) {
                countOfOnes += number[digitId] - '0';
            }
            gamma <<= 1;
            gamma |= (countOfOnes > numberCount / 2 ? 1 : 0);
        }

        final long epsilon = ~gamma & ~(~0L << numberLength);

        return epsilon*gamma;
    }
}
