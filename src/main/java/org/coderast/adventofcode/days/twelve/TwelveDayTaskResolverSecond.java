package org.coderast.adventofcode.days.twelve;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Stream;

public class TwelveDayTaskResolverSecond extends TwelveDayTaskResolver {
    private ImmutableList<String> createWay(final Stack<String> tracing) {
        return tracing.stream().collect(ImmutableList.toImmutableList());
    }
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
            String twiceVisitedSmallCave = null;
            visitedSmallCaves.add(startCaveName);

            final var tracing = new Stack<String>();
            tracing.push(startCaveName);

            while (!tracing.isEmpty()) {
                final var pivotCave = tracing.peek();
                final var finalTwiceVisitedSmallCave = twiceVisitedSmallCave;
                final var optionalNextCave = getPossiblePaths(paths, pivotCave).stream()
                        .map(path -> path.getFirst().equals(pivotCave) ? path.getSecond() : path.getFirst())
                        .filter(nextCave -> !startCaveName.equals(nextCave))
                        .filter(nextCave -> {
                            final boolean isVisited = visitedSmallCaves.contains(nextCave);

                            return !isVisited || finalTwiceVisitedSmallCave == null;
                        })
                        .filter(nextCave -> !visitedWays.contains(createWay(tracing, nextCave)))
                        .findFirst();

                if (optionalNextCave.isEmpty()) {
                    tracing.pop();
                    if (isSmallCave(pivotCave)) {
                        if (pivotCave.equals(twiceVisitedSmallCave)) {
                            twiceVisitedSmallCave = null;
                        } else {
                            visitedSmallCaves.remove(pivotCave);
                        }
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
                    if (visitedSmallCaves.contains(nextCave)) {
                        twiceVisitedSmallCave = nextCave;
                    } else {
                        visitedSmallCaves.add(nextCave);
                    }
                }
            }
        }

        return fullWaysCounter;
    }
}
