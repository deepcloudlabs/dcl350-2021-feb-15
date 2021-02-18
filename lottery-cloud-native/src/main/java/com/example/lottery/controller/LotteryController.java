package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
@RefreshScope
@CrossOrigin("*") 
public class LotteryController {
	@Value("${lottery.max}")
	private int lotteryMax;
	@Value("${lottery.size}")
	private int lotterySize;
	
	@Value("${server.port}")
	private int port;
	
	private LotteryService lotteryService;	

	public LotteryController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}
	
	// http://localhost:6200/lottery/api/v1/numbers
	// http://localhost:6200/lottery/api/v1/numbers?column=10
	@GetMapping
	public List<List<Integer>> getNumbers(
			@RequestParam(required = false, defaultValue = "1") int column){
		System.err.println("Serving at port "+port);
		return lotteryService.draw(lotteryMax, lotterySize, column);
	}

}
