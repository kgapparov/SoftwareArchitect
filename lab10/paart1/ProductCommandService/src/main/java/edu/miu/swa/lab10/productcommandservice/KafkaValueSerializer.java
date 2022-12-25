package edu.miu.swa.lab10.productcommandservice;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class KafkaValueSerializer implements Serializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }

    @Override
    public byte[] serialize(String s, Product stock) {
        try {
            if (stock == null) {
                System.out.println("Null received at serializing");
            }
            System.out.println("Serializing ...");
            return objectMapper.writeValueAsBytes(stock);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Stock into byte []");
        }
    }
}
