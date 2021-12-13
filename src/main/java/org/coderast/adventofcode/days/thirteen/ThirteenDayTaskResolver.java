package org.coderast.adventofcode.days.thirteen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.coderast.adventofcode.days.nine.Point;
import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

public abstract class ThirteenDayTaskResolver implements TaskResolver<ThirteenDayTaskResolver.Input, Long> {
    protected static Point getMirrored(final Point point, final Input.Folding folding) {
        return switch (folding.getAlongCoordinate()) {
            case X -> Point.of((int) (folding.getPosition() * 2 - point.getX()), point.getY());
            case Y -> Point.of(point.getX(), (int) (folding.getPosition() * 2 - point.getY()));
        };
    }

    public static class Input {
        private final ImmutableSet<Point> points;
        private final ImmutableList<Folding> foldings;

        public Input(@Nonnull ImmutableSet<Point> points, @Nonnull ImmutableList<Folding> foldings) {
            this.points = points;
            this.foldings = foldings;
        }

        @Nonnull
        public ImmutableSet<Point> getPoints() {
            return points;
        }

        @Nonnull
        public ImmutableList<Folding> getFoldings() {
            return foldings;
        }

        public static class Folding {
            private final Coordinate alongCoordinate;
            private final long position;

            public Folding(@Nonnull final Coordinate alongCoordinate, long position) {
                this.alongCoordinate = alongCoordinate;
                this.position = position;
            }

            @Nonnull
            public Coordinate getAlongCoordinate() {
                return alongCoordinate;
            }

            public long getPosition() {
                return position;
            }

            public enum Coordinate {
                X, Y;
                public static Coordinate parse(@Nonnull final String coordinate) {
                    return switch (coordinate.toLowerCase()) {
                        case "x" -> X;
                        case "y" -> Y;
                        default -> throw new IllegalStateException("Unexpected value: " + coordinate.toLowerCase());
                    };
                }
            }
        }
    }
}
