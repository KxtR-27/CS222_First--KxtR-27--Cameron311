package edu.bsu.cs;

import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

public class WikiApiFetcher {
    public static WebPageData fetchArticleInformationWithTitle(String title) throws Exception {
        StringBuilder titleFixer = new StringBuilder();
        for (int i = 0; i < title.length(); i++) {
            String letter = title.substring(i, i+1);
            if (letter.equals(" "))
                letter = "+";

            titleFixer.append(letter);
        }

        URI uriForArticle = new URI(
                (String.format(
                        "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&redirects=1&formatversion=2&rvprop=timestamp%s7Cuser&rvlimit=15",
                        titleFixer, "%")
                )
        );
        URL urlForArticle = uriForArticle.toURL();

        URLConnection connectionForArticle = urlForArticle.openConnection();
        connectionForArticle.setRequestProperty("User-Agent", "Revision Reporter/0.1 (connor.razo@bsu.edu)");
        InputStream inputStream = connectionForArticle.getInputStream();

        Scanner streamScanner = new Scanner(inputStream);
        StringBuilder jsonFromScanner = new StringBuilder();
        while (streamScanner.hasNextLine())
            jsonFromScanner.append(streamScanner.nextLine());

        return new WikiApiJsonTranslator(jsonFromScanner.toString()).formatInformation();
    }
    public static WebPageData testingFetchArticleInfoWithJson(String json) throws Exception {
        return new WikiApiJsonTranslator(json).formatInformation();
    }

}
