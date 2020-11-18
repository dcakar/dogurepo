package com.vodafone.zeus.application.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.TimeZone;
import org.springframework.util.CollectionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {
    public static final String INITIAL_JSON = "{}";
    public static final String TIME_ZONE_ISTANBUL = "Europe/Istanbul";
    private static ObjectMapper objectMapper;

    private JsonUtil() {}

    static {
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_ISTANBUL));
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
    }
    @SuppressWarnings("unchecked")
    public static String toJson(Object obj) throws Exception {
        try {
            if (Objects.isNull(obj)) {
                return INITIAL_JSON;
            }
            if (obj instanceof Collection) {
                return CollectionUtils.isEmpty((Collection<Object>) obj) ? INITIAL_JSON : writeAsString(obj);
            }
            if (obj instanceof String) {
                return (String)obj;
            }
            return writeAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception("Hata oluştu");
        }
    }

    private static String writeAsString(Object obj) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static <T> T fromJson(Object obj, Class<T> valueType) throws Exception {
        try {
            if (obj == null) {
                return null;
            }
            return objectMapper.readValue(toJson(obj), valueType);
        } catch (IOException e) {
            throw new Exception("Hata oluştu");
        }
    }
}
