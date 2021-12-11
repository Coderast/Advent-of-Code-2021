package org.coderast.adventofcode.days.nine;

import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.coderast.adventofcode.days.nine.NineDayTaskResolver.*;

public abstract class NineDayTaskResolver implements TaskResolver<Input, Long> {

    protected Stream<Point> getAllAdjacent(final int[][] matrix, final int targetCellX, final int targetCellY) {
        final var builder = Stream.<Point>builder();

        if (targetCellY > 0) { // up
            builder.add(Point.of(targetCellX, targetCellY - 1));
        }

        if (targetCellY < matrix.length - 1) { // down
            builder.add(Point.of(targetCellX, targetCellY + 1));
        }

        if (targetCellX > 0) { // left
            builder.add(Point.of(targetCellX - 1, targetCellY));
        }

        if (targetCellX < matrix[targetCellY].length - 1) { // right
            builder.add(Point.of(targetCellX + 1, targetCellY));
        }

        return builder.build();
    }

    protected Stream<Point> getAllAdjacent(final int[][] matrix, final Point point) {
        return getAllAdjacent(matrix, point.getX(), point.getY());
    }

    protected IntStream getAllAdjacentValues(final int[][] matrix, final int targetCellX, final int targetCellY) {
        return getAllAdjacent(matrix, targetCellX, targetCellY).mapToInt(point -> matrix[point.getY()][point.getX()]);
    }

    protected Stream<Point> getAllLowPoints(final int[][] heightmap) {
        final var lowPointsBuilder = Stream.<Point>builder();
        for (int y = 0; y < heightmap.length; y++) {
            for (int x = 0; x < heightmap[y].length; x++) {
                final var minimalAdjacent = getAllAdjacentValues(heightmap, x, y).min().getAsInt();

                if (minimalAdjacent > heightmap[y][x]) {
                    lowPointsBuilder.add(Point.of(x, y));
                }
            }
        }

        return lowPointsBuilder.build();
    }

    public static class Input {

        private final int[][] heightmap;

        private Input(@Nonnull final int[][] heightmap) {
            this.heightmap = heightmap;
        }

        @Nonnull
        public int[][] getHeightmap() {
            return heightmap;
        }

        @Nonnull
        public static Input withHeightmap(@Nonnull final int[][] heightmap) {
            return new Input(heightmap);
        }
    }
}
