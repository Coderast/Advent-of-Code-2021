package org.coderast.adventofcode.days.nine;

import com.google.common.base.Objects;

public class Point {
    public static final Point ZERO = Point.of(0,0);
    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    public static double distance(final Point left, final Point right) {
        final double dx = left.getX() - right.getX();
        final double dy = left.getY() - right.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }
}
