package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;

public class JsonTranslator {

    public static String parse(InputStream inputStream) throws IOException {
        return JsonPath.read(inputStream, "$..timestamp").toString();
    }
}
