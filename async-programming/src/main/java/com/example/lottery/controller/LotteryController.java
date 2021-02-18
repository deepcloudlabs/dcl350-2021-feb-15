package com.example.lottery.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SimpleLotteryService;

@RestController
@RequestMapping("/numbers")
public class LotteryController {
	
	private SimpleLotteryService lotteryService;	

	public LotteryController(SimpleLotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}
	
	// http://localhost:6200/lottery/api/v1/numbers
	// http://localhost:6200/lottery/api/v1/numbers?column=10
	@GetMapping
	@Async // Event-driven 
	public CompletableFuture<List<Integer>> getNumbers(){
		return lotteryService.draw(60, 6); // 3 sec.
	}

}
