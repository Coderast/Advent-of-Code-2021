package org.coderast.adventofcode.days.ten;

import org.coderast.adventofcode.externalconnect.NetworkWithCookieDataFromSiteSupplier;
import org.coderast.adventofcode.resolving.AbstractInputSupplierWithParser;
import org.coderast.adventofcode.resolving.InputParser;
import org.coderast.adventofcode.resolving.InputSupplier;

import javax.annotation.Nonnull;

public class TenDayInputSupplier extends AbstractInputSupplierWithParser<TenDayTaskResolver.Input> {
    private final static InputParser<TenDayTaskResolver.Input> inputParser = raw -> TenDayTaskResolver.Input.withLines(raw.split("\n"));

    @Nonnull
    @Override
    protected InputParser<TenDayTaskResolver.Input> getInputParser() {
        return inputParser;
    }

    @Nonnull
    @Override
    protected String getMainDataRaw() {
        return NetworkWithCookieDataFromSiteSupplier.getInstance().getMainDataForDay(10);
    }

    @Nonnull
    @Override
    protected String getTestDataRaw() {
        return "[({(<(())[]>[[{[]{<()<>>\n" +
                "[(()[<>])]({[<{<<[]>>(\n" +
                "{([(<{}[<>[]}>{[]{[(<()>\n" +
                "(((({<>}<{<{<>}{[]{[]{}\n" +
                "[[<[([]))<([[{}[[()]]]\n" +
                "[{[{({}]{}}([{[{{{}}([]\n" +
                "{<[[]]>}<{[{[{[]{()[[[]\n" +
                "[<(<(<(<{}))><([]([]()\n" +
                "<{([([[(<>()){}]>(<<{{\n" +
                "<{([{{}}[<[[[<>{}]]]>[]]";
    }
}
