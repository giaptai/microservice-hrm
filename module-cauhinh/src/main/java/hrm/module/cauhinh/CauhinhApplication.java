package hrm.module.cauhinh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CauhinhApplication {
	public static void main(String[] args) {
		SpringApplication.run(CauhinhApplication.class, args);
	}

}
