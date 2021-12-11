package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

public abstract class AbstractInputSupplierWithParser<INPUT> implements InputSupplier<INPUT> {

    @Nonnull
    abstract protected InputParser<INPUT> getInputParser();

    @Nonnull
    abstract protected String getMainDataRaw();
    @Nonnull
    abstract protected String getTestDataRaw();

    @Nonnull
    @Override
    public INPUT getMainInput() {
        return getInputParser().parse(getMainDataRaw());
    }

    @Nonnull
    @Override
    public INPUT getTestInput() {
        return getInputParser().parse(getTestDataRaw());
    }
}
