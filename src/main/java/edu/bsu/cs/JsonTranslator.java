package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.List;
import java.util.Objects;

// These methods are made to be generic,
// so we have chosen to ignore warnings about inline values.
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