package com.hrm.taikhoan.kafka;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.SaslConfigs;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Configuration
@Getter
@Setter
public class KafkaConfig {
    private final String BOOTSTRAP_SERVER = "localhost:9092,localhost:9094,localhost:9096";

    @PostConstruct
    public void createKafkaTopics() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
        properties.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        properties.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
        try (AdminClient adminClient = AdminClient.create(properties)) {
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> topicNames = topics.names().get();
            String topicName = "hoso_create";
            String topicName2 = "taikhoan_email";
            String topicName3 = "tai_khoan";
            String topicName4 = "send_mail";
            Set<String> set = Set.of(topicName, topicName2, topicName3, topicName4);
            if (!topicNames.containsAll(set)) {
                int numPartitions = 3;
                short replicationFactor = 3;
                NewTopic hoso_create = new NewTopic(topicName, numPartitions, replicationFactor);
                NewTopic taikhoan_email = new NewTopic(topicName2, numPartitions, replicationFactor);
                NewTopic tai_khoan = new NewTopic(topicName3, numPartitions, replicationFactor);
                NewTopic send_mail = new NewTopic(topicName4, numPartitions, replicationFactor);
                // Tạo topic
                adminClient.createTopics(Arrays.asList(hoso_create, taikhoan_email, tai_khoan, send_mail));
                System.out.println("Topic create: " + Arrays.toString(set.toArray()) + " đã được tạo thành công.");
            } else System.out.println("Topic exist: " + Arrays.toString(set.toArray()) + " đã tồn tại.");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
