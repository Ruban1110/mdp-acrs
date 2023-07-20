package com.marriott.eeh.srss.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonToJavaConversion {

    public static  <T> T getGeneric(Class<T> clazz, String json) throws JsonProcessingException {
        return  new ObjectMapper().readValue(json, clazz);
    }

}
