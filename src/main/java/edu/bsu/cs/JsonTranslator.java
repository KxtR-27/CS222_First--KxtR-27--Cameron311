package edu.bsu.cs;

public class JsonTranslator {
    String rawJson;

    public JsonTranslator(String rawJson) {
        this.rawJson = rawJson;
    }

    public String giveRawJson() {
        return rawJson;
    }

    public String giveFormattedJson() {
        return "";
    }
}
