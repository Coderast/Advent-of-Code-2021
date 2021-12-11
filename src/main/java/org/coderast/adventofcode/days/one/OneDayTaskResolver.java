package org.coderast.adventofcode.days.one;

import org.coderast.adventofcode.resolving.TaskResolver;

import static org.coderast.adventofcode.days.one.OneDayTaskResolver.*;

public abstract class OneDayTaskResolver implements TaskResolver<Input, Long> {


    public static class Input {
        private final Integer[] measurementArray;

        private Input(final Integer[] measurementArray) {
            this.measurementArray = measurementArray;
        }

        public Integer[] getMeasurementArray() {
            return measurementArray;
        }

        public static OneDayTaskResolverFirst.Input withMeasurements(final Integer[] measurementArray) {
            return new OneDayTaskResolverFirst.Input(measurementArray);
        }
    }
}
