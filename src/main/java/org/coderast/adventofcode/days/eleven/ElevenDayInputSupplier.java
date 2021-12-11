package org.coderast.adventofcode.days.eleven;

import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class ElevenDayInputSupplier extends AbstractInputSupplierWithParser<ElevenDayTaskResolver.Input> {
    private final static InputParser<ElevenDayTaskResolver.Input> inputParser = raw -> ElevenDayTaskResolver.Input.withOctopusMatrix(Arrays.stream(raw.split("\n"))
            .map(line -> line.chars().map(ch -> ch - '0').toArray())
            .toArray(int[][]::new));

    @Nonnull
    @Override
    protected InputParser<ElevenDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(11);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "5483143223\n" +
                "2745854711\n" +
                "5264556173\n" +
                "6141336146\n" +
                "6357385478\n" +
                "4167524645\n" +
                "2176841721\n" +
                "6882881134\n" +
                "4846848554\n" +
                "5283751526";
    }
}
