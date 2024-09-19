package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JsonTranslatorTest {
    JsonTranslator defaultJsonTranslator = new JsonTranslator("{\"continue\":{\"rvcontinue\":\"20240821130526|1241489226\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":[{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"Willem247\",\"timestamp\":\"2024-09-11T23:03:49Z\"},{\"user\":\"Willem247\",\"timestamp\":\"2024-09-11T23:03:06Z\"},{\"user\":\"GreenC bot\",\"timestamp\":\"2024-09-11T06:24:43Z\"},{\"user\":\"Theworldismovingon2022\",\"timestamp\":\"2024-09-10T16:13:29Z\"},{\"user\":\"Kjell Knudde\",\"timestamp\":\"2024-09-07T21:05:19Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-07T19:09:58Z\"},{\"user\":\"Eurukleia\",\"timestamp\":\"2024-09-05T04:31:51Z\"},{\"user\":\"Eurukleia\",\"timestamp\":\"2024-09-05T04:30:19Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-03T21:27:38Z\"},{\"user\":\"Mad420\",\"timestamp\":\"2024-08-29T00:32:05Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-27T16:34:04Z\"},{\"user\":\"Citation bot\",\"timestamp\":\"2024-08-25T15:17:53Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-24T08:15:54Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-24T08:08:03Z\"},{\"user\":\"RobertG\",\"timestamp\":\"2024-08-22T11:19:56Z\"}]}]}}");
    JsonTranslator multipleRedirectsJsonTranslator = new JsonTranslator("{\"continue\":{\"rvcontinue\":\"20240821130526|1241489226\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"},{\"from\":\"Frank Zappa\",\"to\":\"Elephant\"}],\"pages\":[{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"Willem247\",\"timestamp\":\"2024-09-11T23:03:49Z\"},{\"user\":\"Willem247\",\"timestamp\":\"2024-09-11T23:03:06Z\"},{\"user\":\"GreenC bot\",\"timestamp\":\"2024-09-11T06:24:43Z\"},{\"user\":\"Theworldismovingon2022\",\"timestamp\":\"2024-09-10T16:13:29Z\"},{\"user\":\"Kjell Knudde\",\"timestamp\":\"2024-09-07T21:05:19Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-07T19:09:58Z\"},{\"user\":\"Eurukleia\",\"timestamp\":\"2024-09-05T04:31:51Z\"},{\"user\":\"Eurukleia\",\"timestamp\":\"2024-09-05T04:30:19Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-09-03T21:27:38Z\"},{\"user\":\"Mad420\",\"timestamp\":\"2024-08-29T00:32:05Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-27T16:34:04Z\"},{\"user\":\"Citation bot\",\"timestamp\":\"2024-08-25T15:17:53Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-24T08:15:54Z\"},{\"user\":\"Aaw1989\",\"timestamp\":\"2024-08-24T08:08:03Z\"},{\"user\":\"RobertG\",\"timestamp\":\"2024-08-22T11:19:56Z\"}]}]}}");
    @Test
    public void test_getEntriesMatchingTimestampAsString() {
        String expectedListOfTimestampsAsString = "[\"2024-09-11T23:03:49Z\",\"2024-09-11T23:03:06Z\",\"2024-09-11T06:24:43Z\",\"2024-09-10T16:13:29Z\",\"2024-09-07T21:05:19Z\",\"2024-09-07T19:09:58Z\",\"2024-09-05T04:31:51Z\",\"2024-09-05T04:30:19Z\",\"2024-09-03T21:27:38Z\",\"2024-08-29T00:32:05Z\",\"2024-08-27T16:34:04Z\",\"2024-08-25T15:17:53Z\",\"2024-08-24T08:15:54Z\",\"2024-08-24T08:08:03Z\",\"2024-08-22T11:19:56Z\"]";
        String actualListOfTimestampsAsString = defaultJsonTranslator.getEntriesMatchingTargetAsString("timestamp");

        Assertions.assertEquals(expectedListOfTimestampsAsString, actualListOfTimestampsAsString);
    }

    @Test
    public void test_getEntriesMatchingTimestampsAsList() {
        List<String> expectedListOfTimestamps = Arrays.asList(
                "2024-09-11T23:03:49Z",
                "2024-09-11T23:03:06Z",
                "2024-09-11T06:24:43Z",
                "2024-09-10T16:13:29Z",
                "2024-09-07T21:05:19Z",
                "2024-09-07T19:09:58Z",
                "2024-09-05T04:31:51Z",
                "2024-09-05T04:30:19Z",
                "2024-09-03T21:27:38Z",
                "2024-08-29T00:32:05Z",
                "2024-08-27T16:34:04Z",
                "2024-08-25T15:17:53Z",
                "2024-08-24T08:15:54Z",
                "2024-08-24T08:08:03Z",
                "2024-08-22T11:19:56Z"
        );
        List<String> actualListOfTimestamps = defaultJsonTranslator.getEntriesMatchingTargetAsList("timestamp");

        Assertions.assertEquals(expectedListOfTimestamps, actualListOfTimestamps);
    }

    @Test
    public void test_getEntriesMatchingUsersAsString() {
        String expectedListOfUsersAsString = "[\"Willem247\",\"Willem247\",\"GreenC bot\",\"Theworldismovingon2022\",\"Kjell Knudde\",\"Aaw1989\",\"Eurukleia\",\"Eurukleia\",\"Aaw1989\",\"Mad420\",\"Aaw1989\",\"Citation bot\",\"Aaw1989\",\"Aaw1989\",\"RobertG\"]";
        String actualListOfUsersAsString = defaultJsonTranslator.getEntriesMatchingTargetAsString("user");

        Assertions.assertEquals(expectedListOfUsersAsString, actualListOfUsersAsString);
    }

    @Test
    public void test_getEntriesMatchingUsersAsList() {
        List<String> expectedListOfUsers = Arrays.asList(
                "Willem247",
                "Willem247",
                "GreenC bot",
                "Theworldismovingon2022",
                "Kjell Knudde",
                "Aaw1989",
                "Eurukleia",
                "Eurukleia",
                "Aaw1989",
                "Mad420",
                "Aaw1989",
                "Citation bot",
                "Aaw1989",
                "Aaw1989",
                "RobertG"
        );
        List<String> actualListOfUsers = defaultJsonTranslator.getEntriesMatchingTargetAsList("user");

        Assertions.assertEquals(expectedListOfUsers, actualListOfUsers);
    }

    @Test
    public void test_getRevisionAsString(){
        String expected = "[\"Elephant\"]";
        String actual = multipleRedirectsJsonTranslator.getEntriesMatchingTargetAsString("redirects[-1].to");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void test_getRevisionAsList(){
        List<String> expected = Arrays.asList("Elephant");
        List<String> actual = multipleRedirectsJsonTranslator.getEntriesMatchingTargetAsList("redirects[-1].to");
        Assertions.assertEquals(expected,actual);
    }
}
