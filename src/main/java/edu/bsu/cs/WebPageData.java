package edu.bsu.cs;

import java.util.List;
import java.util.Objects;

public class WebPageData {

    // Not named with SNAKE_UPPERCASE because not treated like constants.
    private final String redirect;
    private final List<String> timestamps;
    private final List<String> users;

    public WebPageData(String redirect, List<String> timestamps, List<String> users) {
        this.redirect = redirect;
        this.timestamps = timestamps;
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuilder outputBuilder = new StringBuilder();
        if (!redirect.isEmpty())
            outputBuilder.append(String.format("Redirected to %s%n", redirect));

        for (int i = 0; i < timestamps.size(); i++) {
            outputBuilder.append(String.format("%s  %s%n", timestamps.get(i), users.get(i)));
        }
        return outputBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPageData that = (WebPageData) o;
        return Objects.equals(redirect, that.redirect) && Objects.equals(timestamps, that.timestamps) && Objects.equals(users, that.users);
    }
}
