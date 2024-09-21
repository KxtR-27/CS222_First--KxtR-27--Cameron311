package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonTranslator {
    private final Object jsonAsRereadableDocument;

    public JsonTranslator(String jsonAsString) {
        jsonAsRereadableDocument = Configuration.defaultConfiguration().jsonProvider().parse(jsonAsString);
    }

    public List<String> getAnyValuesAsList(String keyForJsonValue) {
        return JsonPath.read(jsonAsRereadableDocument, String.format("$..%s", keyForJsonValue));
    }

    public String getSingleValueFromList(String pathOfTargetList, int indexInTargetList, String keyForJsonValue) {
        return JsonPath.read(
                jsonAsRereadableDocument,
                String.format("$.%s[%d].%s", pathOfTargetList, indexInTargetList, keyForJsonValue)
        ).toString();
    }

}