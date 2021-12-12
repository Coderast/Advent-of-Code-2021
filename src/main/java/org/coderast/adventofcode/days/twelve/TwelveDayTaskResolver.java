package org.coderast.adventofcode.days.twelve;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.coderast.adventofcode.resolving.TaskResolver;

import javax.annotation.Nonnull;

import static org.coderast.adventofcode.days.twelve.TwelveDayTaskResolver.Input;

public abstract class TwelveDayTaskResolver implements TaskResolver<Input, Long> {
    protected static final String startCaveName = "start";
    protected static final String endCaveName = "end";

    protected static ImmutableList<Path> getPossiblePaths(@Nonnull final ImmutableList<Path> paths, @Nonnull final String name) {
        return paths.stream()
                .filter(path -> path.has(name))
                .collect(ImmutableList.toImmutableList());
    }

    protected static boolean isSmallCave(@Nonnull final String name) {
        return name.toLowerCase().equals(name);
    }

    public static class Path {
        private final String first;
        private final String second;

        private Path(@Nonnull final String first, @Nonnull final String second) {
            this.first = first;
            this.second = second;
        }

        @Nonnull
        public String getFirst() {
            return first;
        }

        @Nonnull
        public String getSecond() {
            return second;
        }

        public boolean has(@Nonnull final String name) {
            return name.equals(first) || name.equals(second);
        }

        @Nonnull
        public static Path of(@Nonnull final String first, @Nonnull final String second) {
            return new Path(first, second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return Objects.equal(first, path.first) && Objects.equal(second, path.second) || Objects.equal(first, path.second) && Objects.equal(second, path.first);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(first, second) + Objects.hashCode(second, first);
        }
    }

    public static class Input {
        private final ImmutableList<Path> paths;

        private Input(@Nonnull final ImmutableList<Path> paths) {
            this.paths = paths;
        }

        @Nonnull
        public ImmutableList<Path> getPaths() {
            return paths;
        }

        @Nonnull
        public static Input withPaths(@Nonnull final ImmutableList<Path> paths) {
            return new Input(paths);
        }
    }
}
