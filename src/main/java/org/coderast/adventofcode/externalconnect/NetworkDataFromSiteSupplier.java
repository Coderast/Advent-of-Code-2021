package org.coderast.adventofcode.externalconnect;

import com.google.common.base.Preconditions;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkDataFromSiteSupplier implements DataFromSiteSupplier {
    private static final String urlPattern = "https://adventofcode.com/2021/day/%d/input";
    private final String cookies;

    protected NetworkDataFromSiteSupplier(String cookies) {
        this.cookies = cookies;
    }

    @Nonnull
    @Override
    public String getMainDataForDay(int day) {
        Preconditions.checkArgument(day >= 0 && day <= 25, "day should be between 1 and 25 inclusive both");

        try {
            URL url = new URL(String.format(urlPattern, day));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("cookie", cookies);
            return IOUtils.toString(con.getInputStream());

        } catch (final ProtocolException | MalformedURLException ex) {
            throw new IllegalStateException("Illegal HTTP usage", ex);
        } catch (final IOException ex) {
            throw new IllegalStateException("Unresolved I/O exception", ex);
        }
    }
}
