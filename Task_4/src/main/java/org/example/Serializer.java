package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.StringWriter;

public class Serializer {

    static public String jsonSerialize(Object obj) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, obj);
        String result = writer.toString();
        return result;
    }

    static public Object jsonDeserialize(String data, Class clazz) throws JsonProcessingException {
        return new ObjectMapper().readValue(data, clazz);
    }
    static public String yamlSerialize(Object obj) throws JsonProcessingException {
        return new ObjectMapper(new YAMLFactory()).writeValueAsString(obj);
    }

    static public Object yamlDeserialize(String data, Class clazz) throws JsonProcessingException {
        return new ObjectMapper(new YAMLFactory()).readValue(data, clazz);
    }

    static public String xmlSerialize(Object obj) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(obj);
    }

    static public Object xmlDeserialize(String data, Class clazz) throws JsonProcessingException {
        return new XmlMapper().readValue(data, clazz);
    }
}
