package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonTranslatorTest {

    @Test
    public void test_returnEmptyString() {
        JsonTranslator jsonTranslator = new JsonTranslator("");
        String rawJson = jsonTranslator.giveRawJson();
        Assertions.assertEquals("", rawJson);
    }

    @Test
    public void test_returnString() {
        JsonTranslator jsonTranslator = new JsonTranslator("json");
        String rawJson = jsonTranslator.giveRawJson();
        Assertions.assertEquals("json", rawJson);
    }

    @Test
    public void test_formatEmptyJson() {
        JsonTranslator jsonTranslator = new JsonTranslator("");
        String formattedJson = jsonTranslator.giveFormattedJson();
        Assertions.assertEquals("", formattedJson);
    }

    @Test
    public void test_formatJson() {
        JsonTranslator jsonTranslator = new JsonTranslator("\"object\": {\"text\":\"test\"}");
        String formattedJson = jsonTranslator.giveFormattedJson();
        Assertions.assertEquals("", formattedJson);
    }

}
