package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WebPageDataTest {
    @Test
    public void test_exampleWebPageData_toString() {
        String redirectForObject = "Frank Zappa";
        List<String> timestampsForObject = Arrays.asList(
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
        List<String> usersForObject = Arrays.asList(
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
        String actualWebPageDataString = new WebPageData(timestampsForObject, usersForObject, redirectForObject).toString();

        String expectedWebPageDataString = "Redirected to Frank Zappa\n" +
                "2024-09-11T23:03:49Z  Willem247\n" +
                "2024-09-11T23:03:06Z  Willem247\n" +
                "2024-09-11T06:24:43Z  GreenC bot\n" +
                "2024-09-10T16:13:29Z  Theworldismovingon2022\n" +
                "2024-09-07T21:05:19Z  Kjell Knudde\n" +
                "2024-09-07T19:09:58Z  Aaw1989\n" +
                "2024-09-05T04:31:51Z  Eurukleia\n" +
                "2024-09-05T04:30:19Z  Eurukleia\n" +
                "2024-09-03T21:27:38Z  Aaw1989\n" +
                "2024-08-29T00:32:05Z  Mad420\n" +
                "2024-08-27T16:34:04Z  Aaw1989\n" +
                "2024-08-25T15:17:53Z  Citation bot\n" +
                "2024-08-24T08:15:54Z  Aaw1989\n" +
                "2024-08-24T08:08:03Z  Aaw1989\n" +
                "2024-08-22T11:19:56Z  RobertG\n";

        Assertions.assertEquals(expectedWebPageDataString, actualWebPageDataString);
    }
}
