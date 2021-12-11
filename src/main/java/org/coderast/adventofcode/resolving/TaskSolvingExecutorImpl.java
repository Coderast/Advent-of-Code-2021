package org.coderast.adventofcode.resolving;

import javax.annotation.Nonnull;

public class TaskSolvingExecutorImpl<INPUT, RESULT> implements TaskSolvingExecutor<RESULT> {
    private final InputSupplier<INPUT> inputSupplier;
    private final TaskResolver<INPUT, RESULT> taskResolver;

    public TaskSolvingExecutorImpl(InputSupplier<INPUT> inputSupplier, TaskResolver<INPUT, RESULT> taskResolver) {
        this.inputSupplier = inputSupplier;
        this.taskResolver = taskResolver;
    }

    @Nonnull
    @Override
    public RESULT execute() {
        return taskResolver.solve(inputSupplier.getMainInput());
    }

    @Nonnull
    @Override
    public RESULT executeTest() {
        return taskResolver.solve(inputSupplier.getTestInput());
    }
}
