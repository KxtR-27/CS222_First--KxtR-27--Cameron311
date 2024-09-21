package edu.bsu.cs;

import java.util.List;

public class WebPageData {

    // Not named with SNAKE_UPPERCASE because not treated like constants.
    private final String redirect;
    private final List<String> timestamps;
    private final List<String> users;

    public WebPageData(List<String> timestamps, List<String> users, String redirect) {
        this.timestamps = timestamps;
        this.redirect = redirect;
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuilder outputBuilder = new StringBuilder();
        if (redirect != null)
            outputBuilder.append(String.format("Redirected to %s%n", redirect));

        for (int i = 0; i < timestamps.size(); i++) {
            outputBuilder.append(String.format("%s  %s%n", timestamps.get(i), users.get(i)));
        }
        return outputBuilder.toString();
    }
}
