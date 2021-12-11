package org.coderast.adventofcode.days.three;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class ThreeDayTaskResolverSecond extends ThreeDayTaskResolver {

    private long findOxygenGeneratorRating(final ImmutableCollection<String> numbers, final long numberLength) {
        var filteredNumbers = numbers;
        for (int i = 0; i < numberLength && filteredNumbers.size() > 1; i++) {
            final int id = i;
            long countOfOnes = 0;
            for (final var number : filteredNumbers) {
                countOfOnes += number.charAt(id) == '1' ? 1 : 0;
            }

            final char frequentBit = countOfOnes >= Math.round(filteredNumbers.size() / 2.0) ? '1' : '0';


            filteredNumbers = filteredNumbers.stream()
                    .filter(number -> number.charAt(id) == frequentBit)
                    .collect(ImmutableList.toImmutableList());
        }
        return filteredNumbers.stream().map(number -> Long.valueOf(number, 2)).findFirst().get();
    }

    private long findCO2ScrubberRating(final ImmutableCollection<String> numbers, final long numberLength) {
        var filteredNumbers = numbers;
        for (int i = 0; i < numberLength && filteredNumbers.size() > 1; i++) {
            final int id = i;
            long countOfOnes = 0;
            for (final var number : filteredNumbers) {
                countOfOnes += number.charAt(id) == '1' ? 1 : 0;
            }

            final char rareBit = countOfOnes >= Math.round(filteredNumbers.size() / 2.0) ? '0' : '1';

            filteredNumbers = filteredNumbers.stream()
                    .filter(number -> number.charAt(id) == rareBit)
                    .collect(ImmutableList.toImmutableList());
        }
        return filteredNumbers.stream().map(number -> Long.valueOf(number, 2)).findFirst().get();
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        char[][] numbersMatrix = input.getNumbersMatrix();

        final int numberLength = numbersMatrix[0].length;

        final var numbersCollection = Arrays.stream(numbersMatrix)
                .map(String::copyValueOf)
                .collect(ImmutableList.toImmutableList());

        return findOxygenGeneratorRating(numbersCollection, numberLength) * findCO2ScrubberRating(numbersCollection, numberLength);
    }
}

