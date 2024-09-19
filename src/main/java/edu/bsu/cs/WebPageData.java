package edu.bsu.cs;

import java.util.List;

public class WebPageData {
    String redirect;
    List<String> timestamps;
    List<String> users;

    public WebPageData(List<String> timestamps, List<String> users, String redirect) {
        this.timestamps = timestamps;
        this.redirect = redirect;
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (redirect != null)
            stringBuilder.append(String.format("Redirected to %s%n", redirect));

        for (int i = 0; i < timestamps.size(); i++) {
            stringBuilder.append(String.format("%s  %s%n", timestamps.get(i), users.get(i)));
        }
        return stringBuilder.toString();
    }
}
