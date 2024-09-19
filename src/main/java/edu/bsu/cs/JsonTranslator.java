package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonTranslator {
    private final Object jsonAsRereadableDocument;

    public JsonTranslator(String jsonAsString) {
        jsonAsRereadableDocument = Configuration.defaultConfiguration().jsonProvider().parse(jsonAsString);
    }

    public List<String> getEntriesMatchingTargetAsList(String target) {
        return JsonPath.read(jsonAsRereadableDocument, String.format("$..%s", target));
    }
    public String getEntriesMatchingTargetAsString(String target) {
        return JsonPath.read(jsonAsRereadableDocument, String.format("$..%s", target)).toString();
    }


}