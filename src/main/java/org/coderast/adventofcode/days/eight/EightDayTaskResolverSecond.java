package org.coderast.adventofcode.days.eight;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EightDayTaskResolverSecond extends EightDayTaskResolver {
    /*
    Original mapping
           aaaa
          b    c
          b    c
           dddd
          e    f
          e    f
           gggg
    */
    private static class DigitRepresentation {
        private final int digit;
        private final ImmutableSet<Character> representation;

        public DigitRepresentation(final int digit, @Nonnull final ImmutableSet<Character> representation) {
            this.digit = digit;
            this.representation = representation;
        }

        public int getDigit() {
            return digit;
        }

        @Nonnull
        public ImmutableSet<Character> getRepresentation() {
            return representation;
        }
    }

    private static class DigitRepresentationSet {
        private final ImmutableList<DigitRepresentation> digitRepresentations;

        private DigitRepresentationSet(@Nonnull final ImmutableList<DigitRepresentation> digitRepresentations) {
            this.digitRepresentations = digitRepresentations;
        }

        public int findByRepresentation(final ImmutableSet<Character> representation) {
            return digitRepresentations.stream()
                    .filter(digitRepresentation -> digitRepresentation.getRepresentation().equals(representation))
                    .map(DigitRepresentation::getDigit)
                    .findFirst()
                    .get();
        }

        public ImmutableSet<Character> findRepresentation(final int digit) {
            return digitRepresentations.stream()
                    .filter(digitRepresentation -> digitRepresentation.getDigit() == digit)
                    .map(DigitRepresentation::getRepresentation)
                    .findFirst()
                    .get();

        }

    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        return input.getScreenInputs().stream()
                .mapToLong(screen -> {
                    final var allDigits = ImmutableList.<String>builder()
                            .addAll(screen.getHelpDigits())
                            .addAll(screen.getOutputDigits())
                            .build();

                    final var wellKnownDigits = new DigitRepresentationSet(allDigits.stream()
                            .filter(digit -> digit.length() == 2 || digit.length() == 4 || digit.length() == 3 || digit.length() == 7)
                            .map(digit -> new DigitRepresentation(
                                    switch (digit.length()) {
                                        case 2 -> 1;
                                        case 4 -> 4;
                                        case 3 -> 7;
                                        case 7 -> 8;
                                        default -> throw new IllegalStateException("Unexpected value: " + digit.length());
                                    }, digit.chars().mapToObj(ch -> (char) ch).collect(ImmutableSet.toImmutableSet())))
                            .collect(ImmutableList.toImmutableList()));

                    final var ONE = wellKnownDigits.findRepresentation(1);
                    final var FOUR = wellKnownDigits.findRepresentation(4);
                    final var SEVEN = wellKnownDigits.findRepresentation(7);
                    final var EIGHT = wellKnownDigits.findRepresentation(8);

                    final var firstStageRemain = allDigits.stream()
                            .map(digit -> digit.chars().mapToObj(ch -> (char) ch).collect(ImmutableSet.toImmutableSet()))
                            .filter(digit -> !digit.equals(ONE))
                            .filter(digit -> !digit.equals(FOUR))
                            .filter(digit -> !digit.equals(SEVEN))
                            .filter(digit -> !digit.equals(EIGHT))
                            .collect(ImmutableList.toImmutableList());

                    final var NINE = firstStageRemain.stream()
                            .filter(digit -> Sets.intersection(digit, ONE).equals(ONE))
                            .filter(digit -> Sets.intersection(digit, FOUR).equals(FOUR))
                            .filter(digit -> Sets.intersection(digit, SEVEN).equals(SEVEN))
                            .findFirst()
                            .orElseThrow();

                    final var TWO = firstStageRemain.stream()
                            .filter(digit -> Sets.intersection(digit, ONE).size() == 1)
                            .filter(digit -> Sets.intersection(digit, FOUR).size() == 2)
                            .filter(digit -> Sets.intersection(digit, SEVEN).size() == 2)
                            .filter(digit -> !digit.equals(EIGHT))
                            .findFirst()
                            .orElseThrow();

                    final var secondStageRemain = firstStageRemain.stream()
                            .filter(digit -> !digit.equals(TWO))
                            .filter(digit -> !digit.equals(NINE))
                            .collect(ImmutableList.toImmutableList());

                    final var FIVE = secondStageRemain.stream()
                            .filter(digit -> Sets.intersection(digit, TWO).size() == 3)
                            .findFirst()
                            .orElseThrow();

                    final var THREE = secondStageRemain.stream()
                            .filter(digit -> !digit.equals(FIVE))
                            .filter(digit -> Sets.intersection(digit, NINE).equals(digit))
                            .findFirst()
                            .orElseThrow();

                    final var thirdStageRemain = secondStageRemain.stream()
                            .filter(digit -> !digit.equals(FIVE))
                            .filter(digit -> !digit.equals(THREE))
                            .collect(ImmutableList.toImmutableList());

                    final var SIX = thirdStageRemain.stream()
                            .filter(digit -> Sets.intersection(digit, NINE).equals(FIVE))
                            .findFirst()
                            .orElseThrow();

                    final var ZERO = thirdStageRemain.stream()
                            .filter(digit -> !digit.equals(SIX))
                            .findFirst()
                            .orElseThrow();

                    final var finalRepresentationTable = new DigitRepresentationSet(ImmutableList.of(
                            new DigitRepresentation(0, ZERO),
                            new DigitRepresentation(1, ONE),
                            new DigitRepresentation(2, TWO),
                            new DigitRepresentation(3, THREE),
                            new DigitRepresentation(4, FOUR),
                            new DigitRepresentation(5, FIVE),
                            new DigitRepresentation(6, SIX),
                            new DigitRepresentation(7, SEVEN),
                            new DigitRepresentation(8, EIGHT),
                            new DigitRepresentation(9, NINE)
                    ));

                    return Long.valueOf(screen.getOutputDigits().stream()
                            .map(digit -> digit.chars().mapToObj(ch -> (char) ch).collect(ImmutableSet.toImmutableSet()))
                            .map(finalRepresentationTable::findByRepresentation)
                            .map(String::valueOf)
                            .collect(Collectors.joining()), 10);
                })
                .sum();
    }
}
