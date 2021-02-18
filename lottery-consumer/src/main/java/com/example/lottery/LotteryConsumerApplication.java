package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "com.example.lottery.client")
public class LotteryConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryConsumerApplication.class, args);
	}

}
