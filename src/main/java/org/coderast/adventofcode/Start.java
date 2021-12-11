package org.coderast.adventofcode;

import org.coderast.adventofcode.resolving.TaskSolvingExecutorFactory;

public class Start {

    public static void main(String[] args) {
        final var executorFactory = new TaskSolvingExecutorFactory();

        final var executor = executorFactory.supplyExecutorFor(2, 2);

        System.out.printf("Answer: %s%n", executor.execute());
        System.out.printf("Test answer: %s%n", executor.executeTest());
    }
}
