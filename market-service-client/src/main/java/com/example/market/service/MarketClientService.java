package com.example.market.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.market.dto.Ticker;

@Service
public class MarketClientService {
	@Value("${market.rest.url}")
	private String marketRestUrl;
	
	@Scheduled(fixedRate = 1_000)
	public void readTickerPrice() {
		var restTemplate = new RestTemplate();
		var ticker = restTemplate.getForEntity(marketRestUrl, Ticker.class)
				                 .getBody();
		System.out.println(ticker);
	}
}
