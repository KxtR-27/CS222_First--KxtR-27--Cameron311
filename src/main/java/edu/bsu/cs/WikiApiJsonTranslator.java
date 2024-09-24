package edu.bsu.cs;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;
import java.util.List;

public class WikiApiJsonTranslator extends JsonTranslator {
    public WikiApiJsonTranslator(String jsonAsString) {
        super(jsonAsString);
    }

    public WebPageData formatInformation() throws Exception {
        checkForInvalidCharacters();
        checkForMissingPage();

        String redirect = getLastRedirect();
        List<String> timestamps = getListOfTimestamps();
        List<String> users = getListOfUsers();

        return new WebPageData(redirect, timestamps, users);
    }

    private void checkForMissingPage() throws Exception {
        String articleTitle = getSingleValueFromList("query.pages", 0, "title");
        throwExceptionIf(
                checkIfJsonContainsPair("missing","true"),
                new NameNotFoundException(String.format("Article by name \"%s\" is missing or doesn't exist.", articleTitle))
        );
    }
    private void checkForInvalidCharacters() throws Exception {
        throwExceptionIf(
                checkIfJsonContainsPair("invalid","true"),
                new InvalidNameException(getAnyValuesAsList("invalidreason").toString())
        );
    }

    private String getLastRedirect() {
        if (checkIfJsonHasList("redirects"))
            return getSingleValueFromList("query.redirects", -1, "to");
        else
            return "";
    }
    private List<String> getListOfTimestamps() {
        return getAnyValuesAsList("timestamp");
    }
    private List<String> getListOfUsers() {
        return getAnyValuesAsList("user");
    }
}
