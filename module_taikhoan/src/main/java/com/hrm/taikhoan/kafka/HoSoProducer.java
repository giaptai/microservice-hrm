package com.hrm.taikhoan.kafka;

import com.hrm.taikhoan.dto.request.ReqHoSo;
import com.hrm.taikhoan.dto.request.ReqTaiKhoan;
import lombok.Getter;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Getter
public class HoSoProducer {
    Properties properties;
    final String BOOTSTRAP_SERVER = "localhost:9092";
    public HoSoProducer() {
        this.properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ReqHoSo.ReqHoSoSerializer.class.getName());
    }
}
