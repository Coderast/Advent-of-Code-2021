package org.coderast.adventofcode.days.three;

import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class ThreeDayInputSupplier extends AbstractInputSupplierWithParser<ThreeDayTaskResolver.Input> {
    private final static InputParser<ThreeDayTaskResolver.Input> inputParser = raw ->
            ThreeDayTaskResolver.Input.withRawBinaryNumbers(Arrays.stream(raw.split("\n")).map(String::toCharArray).toArray(char[][]::new));

    @Nonnull
    @Override
    protected InputParser<ThreeDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(3);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010";
    }
}
