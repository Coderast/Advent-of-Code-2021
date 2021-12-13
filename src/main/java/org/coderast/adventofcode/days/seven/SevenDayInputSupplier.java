package org.coderast.adventofcode.days.seven;

import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class SevenDayInputSupplier extends AbstractInputSupplierWithParser<SevenDayTaskResolver.Input> {
    private static final InputParser<SevenDayTaskResolver.Input> inputParser = raw -> SevenDayTaskResolver.Input.withCrabPositions(Arrays.stream(raw.split(","))
            .map(String::trim)
            .mapToLong(Long::parseLong)
            .toArray());

    @Nonnull
    @Override
    protected InputParser<SevenDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(7);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "16,1,2,0,4,2,7,1,2,14";
    }
}
