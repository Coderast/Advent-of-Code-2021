package org.coderast.adventofcode.days.thirteen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.coderast.adventofcode.days.nine.Point;
import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

import static org.coderast.adventofcode.days.thirteen.ThirteenDayTaskResolver.Input.Folding.*;

public class ThirteenDayInputSupplier extends AbstractInputSupplierWithParser<ThirteenDayTaskResolver.Input> {
    private static final InputParser<ThirteenDayTaskResolver.Input> inputParser = raw -> {
        final var splattedInput = raw.split("\n\n");

        final var dotsCoordinate = Arrays.stream(splattedInput[0].split("\n"))
                .map(line -> line.split(","))
                .map(coords -> Point.of(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])))
                .collect(ImmutableSet.toImmutableSet());

        final var foldingInstructions = Arrays.stream(splattedInput[1].split("\n"))
                .map(line -> line.split("fold along "))
                .map(line -> line[1])
                .map(line -> line.split("="))
                .map(line -> new ThirteenDayTaskResolver.Input.Folding(Coordinate.parse(line[0]), Long.parseLong(line[1])))
                .collect(ImmutableList.toImmutableList());

        return new ThirteenDayTaskResolver.Input(dotsCoordinate, foldingInstructions);
    };

    @Nonnull
    @Override
    protected InputParser<ThirteenDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(13);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "6,10\n" +
                "0,14\n" +
                "9,10\n" +
                "0,3\n" +
                "10,4\n" +
                "4,11\n" +
                "6,0\n" +
                "6,12\n" +
                "4,1\n" +
                "0,13\n" +
                "10,12\n" +
                "3,4\n" +
                "3,0\n" +
                "8,4\n" +
                "1,10\n" +
                "2,14\n" +
                "8,10\n" +
                "9,0\n" +
                "\n" +
                "fold along y=7\n" +
                "fold along x=5";
    }
}
