package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class JsonTranslatorTest {

    @Test
    public void test_parseJson() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("frank_zappa_test.json");
        String returnedJson = JsonTranslator.parse(testDataStream);
        Assertions.assertEquals("[\"2024-09-11T23:03:49Z\",\"2024-09-11T23:03:06Z\",\"2024-09-11T06:24:43Z\",\"2024-09-10T16:13:29Z\",\"2024-09-07T21:05:19Z\",\"2024-09-07T19:09:58Z\",\"2024-09-05T04:31:51Z\",\"2024-09-05T04:30:19Z\",\"2024-09-03T21:27:38Z\",\"2024-08-29T00:32:05Z\",\"2024-08-27T16:34:04Z\",\"2024-08-25T15:17:53Z\",\"2024-08-24T08:15:54Z\",\"2024-08-24T08:08:03Z\",\"2024-08-22T11:19:56Z\"]", returnedJson);
    }

}
