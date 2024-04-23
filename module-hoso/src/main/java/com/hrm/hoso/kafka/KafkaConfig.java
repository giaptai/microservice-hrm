package com.hrm.hoso.kafka;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Getter
@Setter
public class KafkaConfig {
    Properties properties;
    final String BOOTSTRAP_SERVER = "localhost:9092";
    String key;
    String value;
    public KafkaConfig() {
    }

    public KafkaConfig(String key, String value) {
        this.properties = new Properties();
        this.key = key;
        this.value = value;
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
    }
}
