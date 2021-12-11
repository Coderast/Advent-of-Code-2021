package org.coderast.adventofcode.days.eleven;

import org.coderast.adventofcode.days.nine.Point;
import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.coderast.adventofcode.days.eleven.ElevenDayTaskResolver.*;

public abstract class ElevenDayTaskResolver implements TaskResolver<Input, Long> {
    protected static Stream<Point> getAllAdjacent(final int[][] matrix, final int targetCellX, final int targetCellY) {
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

        { // diagonals
            if (targetCellY > 0 && targetCellX > 0) {
                builder.add(Point.of(targetCellX - 1, targetCellY - 1));
            }

            if (targetCellY < matrix.length - 1 && targetCellX < matrix[targetCellY].length - 1) { // down
                builder.add(Point.of(targetCellX + 1, targetCellY + 1));
            }

            if (targetCellX > 0 && targetCellY < matrix.length - 1) { // left
                builder.add(Point.of(targetCellX - 1, targetCellY + 1));
            }

            if (targetCellY > 0 && targetCellX < matrix[targetCellY].length - 1) { // right
                builder.add(Point.of(targetCellX + 1, targetCellY - 1));
            }
        }

        return builder.build();
    }

    protected static Stream<Point> getAllAdjacent(final int[][] matrix, final Point point) {
        return getAllAdjacent(matrix, point.getX(), point.getY());
    }

    protected static IntStream getAllAdjacentValues(final int[][] matrix, final int targetCellX, final int targetCellY) {
        return getAllAdjacent(matrix, targetCellX, targetCellY).mapToInt(point -> matrix[point.getY()][point.getX()]);
    }

    protected static long turnRound(final int[][] octopusMatrix) {
        final Queue<Point> flashedPoints = new LinkedList<>();
        { // Iterate all
            for (int i = 0; i < octopusMatrix.length; i++) {
                for (int j = 0; j < octopusMatrix[i].length; j++) {
                    octopusMatrix[i][j]++;
                    if (octopusMatrix[i][j] > 9) {
                        octopusMatrix[i][j] = 0;
                        flashedPoints.add(Point.of(j, i));
                    }
                }
            }
        }

        { // Handle adjacent
            while (!flashedPoints.isEmpty()) {
                final var flashedPoint = flashedPoints.poll();
                getAllAdjacent(octopusMatrix, flashedPoint)
                        .forEach(adjacent -> {
                            final int x = adjacent.getX();
                            final int y = adjacent.getY();

                            if (octopusMatrix[y][x] != 0 && ++octopusMatrix[y][x] > 9) {
                                octopusMatrix[y][x] = 0;
                                flashedPoints.add(adjacent);
                            }
                        });
            }

        }

        return Arrays.stream(octopusMatrix).flatMapToInt(Arrays::stream).filter(power -> power == 0).count();
    }

    public static class Input {
        private final int[][] octopusMatrix;

        private Input(@Nonnull int[][] octopusMatrix) {
            this.octopusMatrix = octopusMatrix;
        }

        @Nonnull
        public int[][] getOctopusMatrix() {
            return octopusMatrix;
        }

        @Nonnull
        public static Input withOctopusMatrix(@Nonnull final int[][] octopusMatrix) {
            return new Input(octopusMatrix);
        }
    }
}
