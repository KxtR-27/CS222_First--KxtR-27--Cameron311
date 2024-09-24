package edu.bsu.cs;

import java.io.InputStream;
import java.net.*;

public class WikiApiFetcher {
    public static WebPageData fetchArticleInformationWithTitle(String title) throws Exception {
        URI uriForArticle = new URI((String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&redirects=1&formatversion=2&rvprop=timestamp%s7Cuser&rvlimit=15", title, "%")));
        URL urlForArticle = uriForArticle.toURL();

        URLConnection connectionForArticle = urlForArticle.openConnection();
        connectionForArticle.setRequestProperty("User-Agent", "Revision Reporter/0.1 (connor.razo@bsu.edu)");
        InputStream inputStream = connectionForArticle.getInputStream();

        return new WikiApiJsonTranslator(inputStream.toString()).formatInformation();
    }
    public static WebPageData testingFetchArticleInfoWithFilename(String json) throws Exception {
        return new WikiApiJsonTranslator(json).formatInformation();
    }

}
