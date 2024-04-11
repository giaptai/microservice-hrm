package com.hrm.hoso_chitiet.kafka;

import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Getter
public class KafkaConsumerConfig {
    Properties properties;
    final String BOOTSTRAP_SERVER = "localhost:9092";
    String GROUP_ID;
    String key;
    String value;

    public KafkaConsumerConfig(String GROUP_ID, String key, String value) {
        this.properties = new Properties();
        this.GROUP_ID = GROUP_ID;
        this.key = key;
        this.value = value;
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, key);
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, value);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        //Auto Offset Reset is set to "earliest", which means on the first run of the application we will be reading all historical data in our topic.
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    }
}
