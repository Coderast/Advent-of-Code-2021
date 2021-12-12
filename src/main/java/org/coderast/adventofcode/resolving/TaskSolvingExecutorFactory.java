package org.coderast.adventofcode.resolving;

import com.google.common.base.Preconditions;
import org.coderast.adventofcode.days.eleven.ElevenDayInputSupplier;
import org.coderast.adventofcode.days.eleven.ElevenDayTaskResolverFirst;
import org.coderast.adventofcode.days.eleven.ElevenDayTaskResolverSecond;
import org.coderast.adventofcode.days.nine.NineDayInputSupplier;
import org.coderast.adventofcode.days.nine.NineDayTaskResolverFirst;
import org.coderast.adventofcode.days.nine.NineDayTaskResolverSecond;
import org.coderast.adventofcode.days.one.OneDayInputSupplier;
import org.coderast.adventofcode.days.one.OneDayTaskResolver;
import org.coderast.adventofcode.days.one.OneDayTaskResolverFirst;
import org.coderast.adventofcode.days.one.OneDayTaskResolverSecond;
import org.coderast.adventofcode.days.ten.TenDayInputSupplier;
import org.coderast.adventofcode.days.ten.TenDayTaskResolverFirst;
import org.coderast.adventofcode.days.ten.TenDayTaskResolverSecond;
import org.coderast.adventofcode.days.three.ThreeDayInputSupplier;
import org.coderast.adventofcode.days.three.ThreeDayTaskResolverFirst;
import org.coderast.adventofcode.days.three.ThreeDayTaskResolverSecond;
import org.coderast.adventofcode.days.twelve.TwelveDayInputSupplier;
import org.coderast.adventofcode.days.twelve.TwelveDayTaskResolverFirst;
import org.coderast.adventofcode.days.twelve.TwelveDayTaskResolverSecond;
import org.coderast.adventofcode.days.two.TwoDayInputSupplier;
import org.coderast.adventofcode.days.two.TwoDayTaskResolverFirst;
import org.coderast.adventofcode.days.two.TwoDayTaskResolverSecond;

import static com.google.common.base.Preconditions.*;

public class TaskSolvingExecutorFactory {
    public TaskSolvingExecutor supplyExecutorFor(final int day, final int part) {
        checkArgument(part == 1 || part == 2, "part should be 1 or 2");
        checkArgument(day >= 1 && day <= 25, "days should be from 1 to 25 inclusive both");

        return switch (day) {
            case 1 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new OneDayInputSupplier(), new OneDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new OneDayInputSupplier(), new OneDayTaskResolverSecond());
            case 2 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new TwoDayInputSupplier(), new TwoDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new TwoDayInputSupplier(), new TwoDayTaskResolverSecond());
            case 3 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new ThreeDayInputSupplier(), new ThreeDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new ThreeDayInputSupplier(), new ThreeDayTaskResolverSecond());
            //case 4 -> ;
            //case 5 -> ;
            //case 6 -> ;
            //case 7 -> ;
            //case 8 -> ;
            case 9 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new NineDayInputSupplier(), new NineDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new NineDayInputSupplier(), new NineDayTaskResolverSecond());
            case 10 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new TenDayInputSupplier(), new TenDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new TenDayInputSupplier(), new TenDayTaskResolverSecond());
            case 11 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new ElevenDayInputSupplier(), new ElevenDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new ElevenDayInputSupplier(), new ElevenDayTaskResolverSecond());
            case 12 -> part == 1
                    ? new TaskSolvingExecutorImpl<>(new TwelveDayInputSupplier(), new TwelveDayTaskResolverFirst())
                    : new TaskSolvingExecutorImpl<>(new TwelveDayInputSupplier(), new TwelveDayTaskResolverSecond());
            //case 13 -> ;
            //case 14 -> ;
            //case 15 -> ;
            //case 16 -> ;
            //case 17 -> ;
            //case 18 -> ;
            //case 19 -> ;
            //case 20 -> ;
            //case 21 -> ;
            //case 22 -> ;
            //case 23 -> ;
            //case 24 -> ;
            //case 25 -> ;
            default -> throw new IllegalStateException(String.format("Unresolved %d day yet", day));
        };
    }
}
