//package com.hrm.hoso.kafka;
//
//import com.hrm.hoso.models.HoSo;
//import com.hrm.hoso.repository.HoSoRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.connect.connector.Task;
//import org.apache.kafka.connect.source.SourceRecord;
//import org.apache.kafka.connect.source.SourceTask;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//@Component
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public class MySqlSourceTask extends SourceTask {
//    final HoSoRepository hoSoRepository;
//
//    @Override
//    public String version() {
//        return "0.0.1";
//    }
//
//    @Override
//    public void start(Map<String, String> props) {
//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
//        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        props.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
//    }
//
//    @Override
//    public List<SourceRecord> poll() throws InterruptedException {
//        // Retrieve data from the database using the repository
//        List<HoSo> hosos = hoSoRepository.findAll();
////        SourceRecord record = new
//        return null;
//    }
//
//    @Override
//    public void stop() {
//
//    }
//}
