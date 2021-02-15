package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
@RequestScope
@CrossOrigin("*") 
public class LotteryController {
	// Dependency Injection
	// @Autowired // field injection
	private LotteryService lotteryService;
	
	/* @Autowired // setter injection
	public void setLotteryService(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}*/
	
	// Constructor Injection
	public LotteryController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	// http://localhost:6100/lottery/api/v1/numbers?column=10&size=6&max=60
	@GetMapping(params = {"column", "size", "max"} // default representation: JSON
			// produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }
			)
	public List<List<Integer>> getNumbers(
			@RequestParam(value = "max") int max,
			@RequestParam int size,
			@RequestParam int column){
		return lotteryService.draw(max, size, column);
	}
}
