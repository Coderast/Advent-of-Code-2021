package org.coderast.adventofcode.days.twelve;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Stream;

public class TwelveDayTaskResolverFirst extends TwelveDayTaskResolver {

    private ImmutableList<String> createWay(final Stack<String> tracing, final String next) {
        return Stream.concat(tracing.stream(), Stream.of(next)).collect(ImmutableList.toImmutableList());
    }

    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var paths = input.getPaths();


        long fullWaysCounter = 0;
        {
            final var visitedWays = new HashSet<ImmutableList<String>>();
            final var visitedSmallCaves = new HashSet<String>();
            visitedSmallCaves.add(startCaveName);

            final var tracing = new Stack<String>();
            tracing.push(startCaveName);

            while (!tracing.isEmpty()) {
                final var pivotCave = tracing.peek();
                final var optionalNextCave = getPossiblePaths(paths, pivotCave).stream()
                        .filter(path -> path.getFirst().equals(pivotCave) ? !visitedSmallCaves.contains(path.getSecond()) : !visitedSmallCaves.contains(path.getFirst()))
                        .filter(path -> {
                            final var nextCave = path.getFirst().equals(pivotCave) ? path.getSecond() : path.getFirst();

                            return !visitedWays.contains(createWay(tracing, nextCave));
                        })
                        .map(path -> path.getFirst().equals(pivotCave) ? path.getSecond() : path.getFirst())
                        .findFirst();

                if (optionalNextCave.isEmpty()) {
                    tracing.pop();
                    if (isSmallCave(pivotCave)) {
                        visitedSmallCaves.remove(pivotCave);
                    }
                    if (!tracing.isEmpty()) {
                        visitedWays.add(createWay(tracing, pivotCave));
                    }
                    continue;
                }

                final var nextCave = optionalNextCave.get();

                if (endCaveName.equals(nextCave)) {
                    fullWaysCounter++;
                    visitedWays.add(createWay(tracing, endCaveName));
                    continue;
                }

                tracing.push(nextCave);
                if (isSmallCave(nextCave)) {
                    visitedSmallCaves.add(nextCave);
                }
            }
        }

        return fullWaysCounter;
    }
}
