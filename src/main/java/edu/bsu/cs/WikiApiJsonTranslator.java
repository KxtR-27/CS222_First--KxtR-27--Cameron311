package edu.bsu.cs;

import java.util.List;

public class WikiApiJsonTranslator extends JsonTranslator {
    public WikiApiJsonTranslator(String jsonAsString) {
        super(jsonAsString);
    }

    public WebPageData formatInformation() {
        String problem = checkForProblems();
        if (!problem.isEmpty())
            return new WebPageData(problem);

        return formatValidFields();
    }
    protected WebPageData formatValidFields() {
        String redirect = getLastRedirect();
        List<String> timestamps = getListOfTimestamps();
        List<String> users = getListOfUsers();

        return new WebPageData(redirect, timestamps, users);
    }

    private String checkForProblems() {
        if (isTitleInvalid()) {
            StringBuilder problemBuilder = new StringBuilder("invalid " + getAnyValuesAsList("invalidreason"));
            int indexOfEscapedCharacters = problemBuilder.indexOf("\\\"");

            if (problemBuilder.indexOf("\\\"") != -1) {
                while (problemBuilder.toString().contains("\\\"")) {
                    problemBuilder.replace(indexOfEscapedCharacters, indexOfEscapedCharacters + 2, "");
                    indexOfEscapedCharacters = problemBuilder.indexOf("\\\"");
                }
            }

            return problemBuilder.toString();
        }
        if (isPageMissing()) {
            return "missing " + getAnyValuesAsList("title");
        }
        return "";
    }
    private boolean isTitleInvalid() {
        return checkIfJsonContainsPair("invalid", "true");
    }
    private boolean isPageMissing() {
        return checkIfJsonContainsPair("missing", "true");
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
