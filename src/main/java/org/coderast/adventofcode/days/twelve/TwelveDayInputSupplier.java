package org.coderast.adventofcode.days.twelve;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.tuple.Pair;
import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class TwelveDayInputSupplier extends AbstractInputSupplierWithParser<TwelveDayTaskResolver.Input> {
    private final static InputParser<TwelveDayTaskResolver.Input> inputParser = raw -> TwelveDayTaskResolver.Input.withPaths(Arrays.stream(raw.split("\n"))
            .map(line -> line.split("-"))
            .map(rawPath -> TwelveDayTaskResolver.Path.of(rawPath[0], rawPath[rawPath.length-1]))
            .collect(ImmutableList.toImmutableList()));

    @Nonnull
    @Override
    protected InputParser<TwelveDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(12);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "start-A\n" +
                "start-b\n" +
                "A-c\n" +
                "A-b\n" +
                "b-d\n" +
                "A-end\n" +
                "b-end";
    }
}
