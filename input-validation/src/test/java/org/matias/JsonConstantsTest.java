package org.matias;
public class JsonConstantsTest {
    public static String VALID = "{\n" +
            "    \"a\": {\n" +
            "        \"i\": \"7cd1ffa8-6749-11ed-9022-0242ac120002\",\n" +
            "        \"t\": \"2022-11-18T11:00:00.111\"\n" +
            "    },\n" +
            "    \"b\": [\n" +
            "        {\n" +
            "            \"p\": \"b.p string 1\",\n" +
            "            \"q\": 12.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"p\": \"b.p string 2\",\n" +
            "            \"q\": 45.45\n" +
            "        }\n" +
            "    ],\n" +
            "    \"c\": [\n" +
            "        {\n" +
            "            \"r\": \"c.r string 1\",\n" +
            "            \"s\": \"c.s string 2\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"r\": \"c.r string 3\",\n" +
            "            \"s\": \"c.s string 4\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static String invalidJson_aRequired = "{\n" +
            "    \"b\": [\n" +
            "        {\n" +
            "            \"p\": \"b.p string 1\",\n" +
            "            \"q\": 12.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"p\": \"b.p string 2\",\n" +
            "            \"q\": 45.45\n" +
            "        }\n" +
            "    ],\n" +
            "    \"c\": [\n" +
            "        {\n" +
            "            \"r\": \"c.r string 1\",\n" +
            "            \"s\": \"c.s string 2\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"r\": \"c.r string 3\",\n" +
            "            \"s\": \"c.s string 4\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
