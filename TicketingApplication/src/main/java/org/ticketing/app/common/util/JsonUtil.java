package org.ticketing.app.common.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import org.springframework.util.CollectionUtils;
import org.ticketing.app.common.constant.Constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    
    private JsonUtil() {
        
    }

    @SuppressWarnings("unchecked")
    public static String toJson(Object obj) throws Exception {
        try {
            if (Objects.isNull(obj)) {
                return Constants.INITIAL_JSON;
            }
            if (obj instanceof Collection) {
                return CollectionUtils.isEmpty((Collection<Object>) obj) ? Constants.INITIAL_JSON : writeAsString(obj);
            }
            if (obj instanceof String) {
                return (String)obj;
            }
            return writeAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception(e);
        }
    }

    private static String writeAsString(Object obj) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static <T> T fromJson(Object obj, Class<T> valueType) throws Exception {
        try {
            if (obj == null) {
                return null;
            }
            return objectMapper.readValue(toJson(obj), valueType);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}
