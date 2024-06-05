//package com.hrm.hoso.kafka;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.common.config.ConfigDef;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.connect.connector.Task;
//import org.apache.kafka.connect.source.SourceConnector;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public class MySqlSourceConnector extends SourceConnector {
//    @Override
//    public void start(Map<String, String> props) {
//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
//        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        props.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
//    }
//
//    @Override
//    public Class<? extends Task> taskClass() {
//        return null;
//    }
//
//    @Override
//    public List<Map<String, String>> taskConfigs(int maxTasks) {
//        return null;
//    }
//
//    @Override
//    public void stop() {
//
//    }
//
//    @Override
//    public ConfigDef config() {
//        return null;
//    }
//
//    @Override
//    public String version() {
//        return "0.0.1";
//    }
//}
