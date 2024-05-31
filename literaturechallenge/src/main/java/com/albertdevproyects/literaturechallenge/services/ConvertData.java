package com.albertdevproyects.literaturechallenge.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertDataClass(String json, Class<T> type) {
        try{
            return objectMapper.readValue(json, type);
        }catch(JsonProcessingException e){
            throw new RuntimeException();
        }
    }
}
