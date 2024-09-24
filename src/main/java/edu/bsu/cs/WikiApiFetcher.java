package edu.bsu.cs;

import org.apache.commons.io.IOUtils;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class WikiApiFetcher {
    public static WebPageData fetchArticleInformationWithTitle(String title) throws Exception {
        title = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String linkForURL = String.format(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&redirects=1&formatversion=2&rvprop=timestamp%s7Cuser&rvlimit=15",
                title, "%"
        );

        URL url = URI.create(linkForURL).toURL();
        String json = IOUtils.toString(url, StandardCharsets.UTF_8);

        return new WikiApiJsonTranslator(json).formatInformation();
    }

    public static WebPageData testingFetchArticleInfoWithJson(String json) throws Exception {
        return new WikiApiJsonTranslator(json).formatInformation();
    }
}
