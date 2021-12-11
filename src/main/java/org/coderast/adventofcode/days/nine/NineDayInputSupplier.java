package org.coderast.adventofcode.days.nine;

import org.coderast.adventofcode.externalconnect.NetworkDataFromSiteSupplier;
import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class NineDayInputSupplier extends AbstractInputSupplierWithParser<NineDayTaskResolver.Input> {
    private final static InputParser<NineDayTaskResolver.Input> inputParser = raw -> NineDayTaskResolver.Input.withHeightmap(Arrays.stream(raw.split("\n"))
            .map(line -> line.chars().map(ch -> ch - '0').toArray())
            .toArray(int[][]::new));

    @Nonnull
    @Override
    protected InputParser<NineDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(9);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "2199943210\n" +
                "3987894921\n" +
                "9856789892\n" +
                "8767896789\n" +
                "9899965678";
    }
}