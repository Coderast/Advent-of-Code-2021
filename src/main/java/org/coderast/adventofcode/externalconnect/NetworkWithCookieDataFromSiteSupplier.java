package org.coderast.adventofcode.externalconnect;

import javax.annotation.Nonnull;

public class NetworkWithCookieDataFromSiteSupplier extends NetworkDataFromSiteSupplier {
    private final static NetworkWithCookieDataFromSiteSupplier instance = new NetworkWithCookieDataFromSiteSupplier();

    private NetworkWithCookieDataFromSiteSupplier() {
        super(System.getProperty("aoc_cookies"));
    }

    @Nonnull
    public static NetworkWithCookieDataFromSiteSupplier getInstance() {
        return instance;
    }
}
