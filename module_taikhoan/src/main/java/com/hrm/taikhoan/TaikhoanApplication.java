package com.hrm.taikhoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaikhoanApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaikhoanApplication.class, args);
	}

}
