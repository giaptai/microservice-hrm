//package com.hrm.hoso_chitiet.kafka;
//
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.common.config.ConfigDef;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.connect.connector.Task;
//import org.apache.kafka.connect.source.SourceConnector;
//import org.apache.kafka.connect.connector.Connector;
//
//import org.apache.kafka.connect.source.SourceTask;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class MySqlSourceConnector extends SourceConnector {
//    // Define configuration properties
//    public static final String MYSQL_HOST_CONFIG = "mysql.host";
//    public static final String MYSQL_PORT_CONFIG = "mysql.port";
//    public static final String MYSQL_DB_CONFIG = "mysql.db";
//    public static final String MYSQL_USER_CONFIG = "mysql.user";
//    public static final String MYSQL_PASSWORD_CONFIG = "mysql.password";
//    private String mysqlHost;
//    private int mysqlPort;
//    private String mysqlDb;
//    private String mysqlUser;
//    private String mysqlPassword;
//    @Override
//    public void start(Map<String, String> props) {
//        mysqlHost = props.get(MYSQL_HOST_CONFIG);
//        mysqlPort = Integer.parseInt(props.get(MYSQL_PORT_CONFIG));
//        mysqlDb = props.get(MYSQL_DB_CONFIG);
//        mysqlUser = props.get(MYSQL_USER_CONFIG);
//        mysqlPassword = props.get(MYSQL_PASSWORD_CONFIG);
//    }
//    @Override
//    public Class<? extends Task> taskClass() {
//        return MySqlSourceTask.class;
//    }
//    @Override
//    public List<Map<String, String>> taskConfigs(int maxTasks) {
//        List<Map<String, String>> configs = new ArrayList<>();
//        Map<String, String> config = new HashMap<>();
//        config.put(MYSQL_HOST_CONFIG, mysqlHost);
//        config.put(MYSQL_PORT_CONFIG, String.valueOf(mysqlPort));
//        config.put(MYSQL_DB_CONFIG, mysqlDb);
//        config.put(MYSQL_USER_CONFIG, mysqlUser);
//        config.put(MYSQL_PASSWORD_CONFIG, mysqlPassword);
//        configs.add(config);
//        return configs;
//    }
//    @Override
//    public void stop() {}
//    @Override
//    public ConfigDef config() {
//        return new ConfigDef()
//                .define(MYSQL_HOST_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "192.168.1.2")
//                .define(MYSQL_PORT_CONFIG, ConfigDef.Type.INT, ConfigDef.Importance.HIGH, "3306")
//                .define(MYSQL_DB_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "ho_so_chi_tiet")
//                .define(MYSQL_USER_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "root")
//                .define(MYSQL_PASSWORD_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "123456");
//    }
//    @Override
//    public String version() {return "1.0";}
//}
//
////    private Map<String, String> prosLocal;
////
////    @Override
////    public void start(Map<String, String> props) {
////        props.put("database.url", "jdbc:mysql://192.168.1.2:3306/ho_so_chi_tiet");
////        props.put("topic.prefix", "khen_thuong");
////        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
////        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
////        props.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
////        this.prosLocal = props;
////    }
////
////    @Override
////    public Class<? extends Task> taskClass() {
////        return MySqlSourceTask.class;
////    }
////
////    @Override
////    public List<Map<String, String>> taskConfigs(int maxTasks) {
////        return null;
////    }
////
////
////    @Override
////    public void stop() {
////
////    }
////
////    @Override
////    public ConfigDef config() {
////        return null;
////    }
////
////    @Override
////    public String version() {
////        return "1.0";
////    }
////@Override
////    public List<Map<String, String>> taskConfigs(int maxTasks) {
////        List<Map<String, String>> taskConfigs = new ArrayList<>();
////        for (int i = 0; i < maxTasks; i++) {
////            Map<String, String> taskConfig = new HashMap<>();
////            prosLocal.put("task.id", String.valueOf(i));
////            prosLocal.put("topic", "khen_thuong");
////            prosLocal.put("database.url", "jdbc:mysql://192.168.1.2:3306/ho_so_chi_tiet");
////            prosLocal.put("database.username", "root");
////            prosLocal.put("database.password", "123456");
////            prosLocal.put("query", "SELECT * FROM khen_thuong");
////            prosLocal.put("poll.interval.ms", "1000"); // 10 seconds
////            taskConfigs.add(taskConfig);
////        }
////        return taskConfigs;
////    }
