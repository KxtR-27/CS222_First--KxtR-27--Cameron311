package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.List;
import java.util.Objects;

// Because this class's methods are designed to be generic,
// we are suppressing warnings about inline parameter values.
@SuppressWarnings("SameParameterValue")

public class JsonTranslator {

    private final Object jsonAsRereadableDocument;

    protected JsonTranslator(String jsonAsString) {
        jsonAsRereadableDocument = Configuration.defaultConfiguration().jsonProvider().parse(jsonAsString);
    }

    protected List<String> getAnyValuesAsList(String keyForJsonValue) {
        return JsonPath.read(jsonAsRereadableDocument, String.format("$..%s", keyForJsonValue));
    }
    protected String getSingleValueFromList(String pathOfTargetList, int indexInTargetList, String keyForJsonValue) {
        return JsonPath.read(
                jsonAsRereadableDocument,
                String.format("$.%s[%d].%s", pathOfTargetList, indexInTargetList, keyForJsonValue)
        ).toString();
    }

    // Because these methods are generic on purpose, we are ignoring these warnings.
    protected boolean checkIfJsonHasList(String nameOfList) {
        return jsonAsRereadableDocument.toString().contains(nameOfList);
    }
    protected boolean checkIfJsonContainsPair(String key, String value) {
        return JsonPath.read(jsonAsRereadableDocument, String.format("$..%s", key)).toString().contains(value);
    }

    protected void throwExceptionIf (boolean condition, Exception e) throws Exception {
        if (condition)
            throw e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonTranslator that = (JsonTranslator) o;
        return this.jsonAsRereadableDocument.toString().equals(that.jsonAsRereadableDocument.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jsonAsRereadableDocument);
    }
}