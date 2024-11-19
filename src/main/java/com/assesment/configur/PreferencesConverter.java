//package com.assesment.configur;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//@Converter
//public class PreferencesConverter implements AttributeConverter<UserPreference.Preferences, String> {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String convertToDatabaseColumn(UserPreference.Preferences preferences) {
//        try {
//            return preferences == null ? null : objectMapper.writeValueAsString(preferences);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to convert Preferences to JSON string.", e);
//        }
//    }
//
//    @Override
//    public UserPreference.Preferences convertToEntityAttribute(String dbData) {
//        try {
//            return dbData == null ? null : objectMapper.readValue(dbData, UserPreference.Preferences.class);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to convert JSON string to Preferences.", e);
//        }
//    }
//}
//
