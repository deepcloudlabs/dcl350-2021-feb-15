package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private LotteryService lotteryService;

	// http://localhost:6100/lottery/api/v1/numbers?column=10&size=6&max=60
	@GetMapping()
	public List<List<Integer>> getNumbers(@RequestParam(required = false, defaultValue = "60") int max,
			@RequestParam(required = false, defaultValue = "6") int size,
			@RequestParam(required = false, defaultValue = "5") int column) {
		return lotteryService.draw(max, size, column);
	}

}
