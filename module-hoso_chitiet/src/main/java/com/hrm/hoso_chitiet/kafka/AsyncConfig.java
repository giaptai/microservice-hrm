package com.hrm.hoso_chitiet.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfig implements SchedulingConfigurer, AsyncConfigurer {
//    final CustomStream customStream;

//    public AsyncConfig(CustomStream customStream) {
//        this.customStream = customStream;
//    }

    //    @Autowired
//    private MySqlSourceTask mySqlSourceTask;
    //    @Bean
//    public Executor taskScheduler() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(5);
//        threadPoolTaskExecutor.setMaxPoolSize(10);
//        threadPoolTaskExecutor.setQueueCapacity(10);
//        threadPoolTaskExecutor.setThreadNamePrefix("my-executor-");
//        threadPoolTaskExecutor.initialize();
//        return threadPoolTaskExecutor;
//    }
//    @Bean
//    public MySqlSourceConnector mySqlSourceConnector() {
//        return new MySqlSourceConnector();
//    }
//
//    @Bean
//    public MySqlSourceTask mySqlSourceTask() {
//        return new MySqlSourceTask();
//    }
//    @Scheduled(fixedRate = 10000)
//    public void runTask() throws InterruptedException {
//        mySqlSourceTask.poll();
//    }
//    @Async
//    @Scheduled(fixedRate = 30_000)
//    public void runTaskCC() {
//        customStream.KhenThuongStream();
//    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("my-executor-");
        executor.initialize();
        return executor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        threadPoolTaskScheduler.initialize();
        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }
}
