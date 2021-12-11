package org.coderast.adventofcode.days.nine;

import javax.annotation.Nonnull;
import java.util.*;

public class NineDayTaskResolverSecond extends NineDayTaskResolver {
    @Nonnull
    @Override
    public Long solve(@Nonnull Input input) {
        final var heightmap = input.getHeightmap();
        return getAllLowPoints(heightmap)
                .map(point -> {
                    final Set<Point> basinSet = new HashSet<>();
                    final Queue<Point> queue =  new LinkedList<>();
                    queue.add(point);

                    while(!queue.isEmpty()) {
                        final var pivotPoint = queue.poll();
                        getAllAdjacent(heightmap, pivotPoint)
                                .filter(cell -> heightmap[cell.getY()][cell.getX()] != 9)
                                .filter(cell -> !basinSet.contains(cell))
                                .forEach(cell -> {
                                    basinSet.add(cell);
                                    queue.add(cell);
                                });
                    }
                    return basinSet.size();
                })
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(size -> size)
                .reduce((left, right) -> left * right)
                .getAsLong();
    }
}
