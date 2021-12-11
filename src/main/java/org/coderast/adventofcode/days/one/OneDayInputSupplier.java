package org.coderast.adventofcode.days.one;

import org.coderast.adventofcode.externalconnect.NetworkDataFromSiteSupplier;
import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class OneDayInputSupplier extends AbstractInputSupplierWithParser<OneDayTaskResolver.Input> {
    private final static InputParser<OneDayTaskResolver.Input> inputParser = raw -> OneDayTaskResolver.Input.withMeasurements(Arrays.stream(raw.split("\n"))
            .map(Integer::valueOf)
            .toArray(Integer[]::new));

    @Nonnull
    @Override
    protected InputParser<OneDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(1);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263";
    }
}
