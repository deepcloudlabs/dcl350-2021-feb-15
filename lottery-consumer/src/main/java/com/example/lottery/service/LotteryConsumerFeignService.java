package com.example.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.lottery.client.LotteryService;

@Service
public class LotteryConsumerFeignService {

	@Autowired
	private LotteryService lotteryService;
	
	@Scheduled(fixedRate = 1_000)
	public void consumeLotteryService() {
		System.out.println(lotteryService.getir(10));
	}
}
