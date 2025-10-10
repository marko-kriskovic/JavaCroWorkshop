package org.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Utility class for converting between JSON strings and Map objects.
 */
public class JsonMapConverter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Converts a JSON string to a Map.
     *
     * @param json the JSON string to convert
     * @return a Map representation of the JSON
     * @throws com.google.gson.JsonSyntaxException if the JSON is malformed
     */
    public static Map<String, Object> jsonToMap(String json) {
        if (json == null || json.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON string cannot be null or empty");
        }

        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Converts a Map to a JSON string.
     *
     * @param map the Map to convert
     * @return a JSON string representation of the Map
     */
    public static String mapToJson(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        return gson.toJson(map);
    }

    /**
     * Converts a Map to a pretty-printed JSON string.
     *
     * @param map the Map to convert
     * @return a pretty-printed JSON string representation of the Map
     */
    public static String mapToPrettyJson(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        return gson.toJson(map);
    }
}
