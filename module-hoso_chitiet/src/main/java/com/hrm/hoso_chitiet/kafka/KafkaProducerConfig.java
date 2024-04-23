package com.hrm.hoso_chitiet.kafka;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaProducerConfig {
    Properties properties;
    final String BOOTSTRAP_SERVER = " localhost:9092";
    String key;
    String value;

    public KafkaProducerConfig() {
    }

//    @Bean
//    public KhenThuongProducerConfig(){
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
//    }

    public KafkaProducerConfig(String key, String value) {
        this.properties = new Properties();
        this.key = key;
        this.value = value;
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
    }
}
