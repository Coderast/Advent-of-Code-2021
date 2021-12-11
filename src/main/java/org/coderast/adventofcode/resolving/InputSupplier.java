package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

public interface InputSupplier<INPUT> {
    @Nonnull
    INPUT getMainInput();

    @Nonnull
    INPUT getTestInput();
}
