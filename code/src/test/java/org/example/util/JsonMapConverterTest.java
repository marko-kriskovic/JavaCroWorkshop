package org.example.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonMapConverterTest {

    @Test
    void testJsonToMap_SimpleObject() {
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        Map<String, Object> result = JsonMapConverter.jsonToMap(json);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("John", result.get("name"));
        assertEquals(30.0, result.get("age")); // Gson parses numbers as doubles
        assertEquals("New York", result.get("city"));
    }

    @Test
    void testJsonToMap_NestedObject() {
        String json = "{\"person\":{\"name\":\"Alice\",\"age\":25},\"active\":true}";
        Map<String, Object> result = JsonMapConverter.jsonToMap(json);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.get("person") instanceof Map);
        assertEquals(true, result.get("active"));

        @SuppressWarnings("unchecked")
        Map<String, Object> person = (Map<String, Object>) result.get("person");
        assertEquals("Alice", person.get("name"));
        assertEquals(25.0, person.get("age"));
    }

    @Test
    void testJsonToMap_EmptyObject() {
        String json = "{}";
        Map<String, Object> result = JsonMapConverter.jsonToMap(json);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testJsonToMap_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            JsonMapConverter.jsonToMap(null);
        });
    }

    @Test
    void testJsonToMap_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            JsonMapConverter.jsonToMap("");
        });
    }

    @Test
    void testJsonToMap_InvalidJson() {
        String invalidJson = "{invalid json}";
        assertThrows(com.google.gson.JsonSyntaxException.class, () -> {
            JsonMapConverter.jsonToMap(invalidJson);
        });
    }

    @Test
    void testMapToJson_SimpleMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John");
        map.put("age", 30);
        map.put("city", "New York");

        String json = JsonMapConverter.mapToJson(map);

        assertNotNull(json);
        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"John\""));
        assertTrue(json.contains("\"age\""));
        assertTrue(json.contains("30"));
    }

    @Test
    void testMapToJson_NestedMap() {
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("name", "Alice");
        innerMap.put("age", 25);

        Map<String, Object> map = new HashMap<>();
        map.put("person", innerMap);
        map.put("active", true);

        String json = JsonMapConverter.mapToJson(map);

        assertNotNull(json);
        assertTrue(json.contains("\"person\""));
        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"Alice\""));
        assertTrue(json.contains("\"active\""));
        assertTrue(json.contains("true"));
    }

    @Test
    void testMapToJson_EmptyMap() {
        Map<String, Object> map = new HashMap<>();
        String json = JsonMapConverter.mapToJson(map);

        assertNotNull(json);
        assertEquals("{}", json);
    }

    @Test
    void testMapToJson_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            JsonMapConverter.mapToJson(null);
        });
    }

    @Test
    void testMapToPrettyJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John");
        map.put("age", 30);

        String json = JsonMapConverter.mapToPrettyJson(map);

        assertNotNull(json);
        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"John\""));
    }

    @Test
    void testRoundTrip_JsonToMapToJson() {
        String originalJson = "{\"name\":\"Bob\",\"age\":35,\"active\":true}";

        // Convert JSON to Map
        Map<String, Object> map = JsonMapConverter.jsonToMap(originalJson);

        // Convert Map back to JSON
        String resultJson = JsonMapConverter.mapToJson(map);

        // Convert result JSON back to Map to compare
        Map<String, Object> resultMap = JsonMapConverter.jsonToMap(resultJson);

        assertEquals(map.size(), resultMap.size());
        assertEquals(map.get("name"), resultMap.get("name"));
        assertEquals(map.get("age"), resultMap.get("age"));
        assertEquals(map.get("active"), resultMap.get("active"));
    }
}
