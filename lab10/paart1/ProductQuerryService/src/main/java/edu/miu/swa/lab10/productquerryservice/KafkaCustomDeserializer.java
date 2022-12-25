package edu.miu.swa.lab10.productquerryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class KafkaCustomDeserializer implements Deserializer<Stock> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Stock deserialize(String s, byte[] bytes) {
        try {
            if (bytes == null) {
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserizlizing ...");
            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), Stock.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Stock");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
