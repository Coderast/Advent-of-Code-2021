package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

public interface TaskSolvingExecutor<RESULT> {
    @Nonnull
    RESULT execute();

    @Nonnull
    RESULT executeTest();
}
