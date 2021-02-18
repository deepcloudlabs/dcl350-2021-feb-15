package com.example.lottery.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LotteryConsumerService {
	private final String lotteryUrl = 
			"/lottery/api/v2/numbers?column=10";
	@Autowired
	private DiscoveryClient discoveryClient;
	private List<ServiceInstance> instances;
	
	@PostConstruct
	public void init() {
		instances = discoveryClient.getInstances("lottery");
		instances.forEach(server -> System.out.println(server.getHost()+":"+server.getPort()));
	}
	
	//@Scheduled(fixedRate = 1_000)
	public void callLotteryService() {
		RestTemplate restTemplate = new RestTemplate();
		var si = instances.get(0);
		var numbers = restTemplate.getForEntity("http://"+si.getHost()+":"+si.getPort()+lotteryUrl, String.class).getBody();
		System.out.println(numbers);
	}
}
