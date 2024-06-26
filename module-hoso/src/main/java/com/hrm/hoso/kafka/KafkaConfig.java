package com.hrm.hoso.kafka;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Configuration
@Getter
@Setter
public class KafkaConfig {
    private Properties properties;
    private final String BOOTSTRAP_SERVER = "localhost:9092,localhost:9094,localhost:9096";
    private String key;
    private String value;

    public KafkaConfig() {
    }

    public KafkaConfig(String key, String value) {
        this.properties = new Properties();
        this.key = key;
        this.value = value;
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        properties.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        properties.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
    }

    @Bean
    public boolean createTopics() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        properties.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        properties.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        try (AdminClient adminClient = AdminClient.create(properties)) {
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> topicNames = topics.names().get();
            String topicName = "qua-trinh-cong-tac";
            Set<String> setTopics = Set.of(topicName);
            if (!topicNames.containsAll(setTopics)) {
                int numPartitions = 3;
                short replicationFactor = 3;
                NewTopic hoso_create = new NewTopic(topicName, numPartitions, replicationFactor);
                // Tạo topic
                adminClient.createTopics(Collections.singleton(hoso_create));
                System.out.println("Topic create: " + Arrays.toString(setTopics.toArray()) + " đã được tạo thành công.");
                return true;
            } else {
                System.err.println("Topic exist: " + Arrays.toString(setTopics.toArray()) + " đã tồn tại.");
                return false;
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
