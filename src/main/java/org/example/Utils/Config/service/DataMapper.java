package org.example.Utils.Config.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.api_models.Entries;
import org.example.api_models.PublicAPI;

import java.util.List;

public class DataMapper {

    public static List<Entries> dataMapper(String jsonString) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        PublicAPI publicAPI = objectMapper.readValue(jsonString, PublicAPI.class);
        return publicAPI.getEntries();
    }
}
