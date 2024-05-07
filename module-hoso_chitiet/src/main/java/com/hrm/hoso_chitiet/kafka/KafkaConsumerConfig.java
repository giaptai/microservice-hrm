package com.hrm.hoso_chitiet.kafka;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafkaConsumerConfig {
    final String BOOTSTRAP_SERVER = "localhost:9092";

    public KafkaConsumerConfig() {
    }

    @Bean
    public Properties quaTrinhCongTacProducerConfig() {
        Properties qtct = getProperties();
//        qtct.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        qtct.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.keystore.jks");
//        qtct.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
//        qtct.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "\\\\wsl.localhost\\Ubuntu\\home\\macmkay\\kafka\\security\\tls\\server.truststore.jks");
//        qtct.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");
//        qtct.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
        qtct.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        qtct.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        qtct.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        return qtct;
    }

    private Properties getProperties() {
        Properties qtct = new Properties();
        qtct.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        qtct.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        qtct.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ResChucVu.ResChucVuSoDeserializer.class.getName());
        qtct.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-quatrinhcongtac-app");
        //Auto Offset Reset is set to "earliest", which means on the first run of the application we will be reading all historical data in our topic.
        qtct.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        return qtct;
    }
}
