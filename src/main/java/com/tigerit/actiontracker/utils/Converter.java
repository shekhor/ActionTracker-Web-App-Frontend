package com.tigerit.actiontracker.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Converter {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <U, V> V convertClass(U mapperObject, Class<V> targetClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(mapperObject, targetClass);
    }

    public static <Source, Dest> void copyProperty(Source source, Dest target) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, target);
    }

    public static <U, V> List<V> toDtoList(List<U> mapperObjects, Class<V> targetClass) {
        List<V> dtoObjects = mapperObjects
                .stream()
                .map(u -> convertClass(u, targetClass))
                .collect(Collectors.toList());

        return dtoObjects;
    }

    public static <U, V> List<V> toDtoList(Iterable<U> mapperObjects, Class<V> targetClass) {
        List<V> dtoObjects = new ArrayList<>();

        mapperObjects.forEach(object -> {
            dtoObjects.add(convertClass(object, targetClass));
        });

        return dtoObjects;
    }


    public static <T> HashMap toHashMapExcludingNull(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HashMap<String, Object> map = objectMapper.convertValue(object, HashMap.class);
        return map;
    }

    public static <T> MultiValueMap<String, String> toMultiValueMapExcludingNull(T object) {
        HashMap<String, String> hashMap = toHashMapExcludingNull(object);
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        if(hashMap == null) {
            return multiValueMap;
        }

        for(Map.Entry<String, String> item: hashMap.entrySet()) {
            multiValueMap.put(item.getKey(), Arrays.asList(String.valueOf(item.getValue())));
        }

        return multiValueMap;
    }

    public static String decodeBase64(String value){
        byte[] decoded = Base64.getDecoder().decode(value);
        String decodedString = new String(decoded);
        return decodedString;
    }
}