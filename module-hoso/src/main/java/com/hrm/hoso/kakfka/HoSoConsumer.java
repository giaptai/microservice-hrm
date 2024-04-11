package com.hrm.hoso.kakfka;

import com.hrm.hoso.dto.request.ReqTaoHoSo;
import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Getter
public class HoSoConsumer {
    Properties properties;
    final String BOOTSTRAP_SERVER = "localhost:9092";
    String GROUP_ID = "my-hoso-app";
    public HoSoConsumer() {
        this.properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ReqTaoHoSo.ReqTaoHoSoDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        //Auto Offset Reset is set to "earliest", which means on the first run of the application we will be reading all historical data in our topic.
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    }
}
