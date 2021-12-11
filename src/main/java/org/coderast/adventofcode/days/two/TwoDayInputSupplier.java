package org.coderast.adventofcode.days.two;

import com.google.common.collect.ImmutableList;
import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

public class TwoDayInputSupplier extends AbstractInputSupplierWithParser<TwoDayTaskResolver.Input> {
    private final static InputParser<TwoDayTaskResolver.Input> inputParser = raw -> TwoDayTaskResolver.Input.withCommands(Arrays.stream(raw.split("\n"))
            .map(line -> line.split(" "))
            .map(splattedLine -> {
                checkArgument(splattedLine.length == 2, String.format("length of tokens should be 2 for line: `%s`", String.join(" ", splattedLine)));

                return new Command(switch (splattedLine[0]) {
                    case "forward" -> Command.CommandType.Forward;
                    case "up" -> Command.CommandType.Up;
                    case "down" -> Command.CommandType.Down;
                    default -> throw new IllegalArgumentException(String.format("Unsupported command %s in line `%s`", splattedLine[0], String.join(" ", splattedLine)));
                }, Integer.parseInt(splattedLine[1]));
            }).collect(ImmutableList.toImmutableList()));

    @Nonnull
    @Override
    protected InputParser<TwoDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(2);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "forward 5\n" +
                "down 5\n" +
                "forward 8\n" +
                "up 3\n" +
                "down 8\n" +
                "forward 2";
    }
}
