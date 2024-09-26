package edu.bsu.cs;

import org.apache.commons.io.IOUtils;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class WikiApiFetcher {
    public static WebPageData checkThenFetch(String title) throws IOException, InvalidNameException, NameNotFoundException {
        WebPageData toReturn;

        try {
            toReturn = fetchArticleInformationWithTitle(title);
            checkDataForErrors(toReturn);
            return toReturn;
        } catch (IOException e) {
            throw new IOException("An unexpected network error has occurred.");
        }

    }
    private static void checkDataForErrors(WebPageData webPageData) throws InvalidNameException, NameNotFoundException {
        String problem = webPageData.getProblem();
        if (problem.contains("invalid"))
            throw new InvalidNameException(problem.substring(8));
        if (problem.contains("missing"))
            throw new NameNotFoundException("Article " + problem.substring(8) + " is missing or does not exist.");
    }

    private static WebPageData fetchArticleInformationWithTitle(String title) throws IOException {
        title = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String linkForURL = String.format(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&redirects=1&formatversion=2&rvprop=timestamp%s7Cuser&rvlimit=15",
                title, "%"
        );

        URL url = URI.create(linkForURL).toURL();
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1.1 (connor.razo@bsu.edu + cameron.witzigreuter@bsu.edu)");
        InputStream inputStream = connection.getInputStream();

        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        return new WikiApiJsonTranslator(json).formatInformation();
    }

    // These methods are made to be generic,
    // so we have chosen to ignore warnings about inline values.
    @SuppressWarnings("SameParameterValue")
    protected static WebPageData testingFetchArticleInfoWithJson(String json) {
        return new WikiApiJsonTranslator(json).formatValidFields();
    }
}