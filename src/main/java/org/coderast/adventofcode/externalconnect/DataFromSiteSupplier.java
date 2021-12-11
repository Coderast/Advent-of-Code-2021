package org.coderast.adventofcode.externalconnect;

import javax.annotation.Nonnull;

public interface DataFromSiteSupplier {
    @Nonnull
    String getMainDataForDay(int day);
}
