package com.assesment.configur;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MetadataConverter implements AttributeConverter<Map<String, Object>, String>{
	   private final ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		 try {
	            return attribute == null ? null : objectMapper.writeValueAsString(attribute);
	        } catch (Exception e) {
	            throw new RuntimeException("Error converting Map to JSON String", e);
	        }
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		try {
            return dbData == null ? new HashMap<>() : objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON String to Map", e);
        }
	}

}
