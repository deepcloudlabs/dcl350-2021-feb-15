package com.example.lottery.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("lottery")
public interface LotteryService {
	@GetMapping("/lottery/api/v2/numbers")
	public List<List<Integer>> getir(@RequestParam int column);
}
