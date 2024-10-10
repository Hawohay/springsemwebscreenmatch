package com.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvertData implements IConvertData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getDataTitle(String json, Class<T> TClass) {
        try {
            return mapper.readValue(json, TClass);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
