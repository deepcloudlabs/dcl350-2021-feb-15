package com.example.bbb.service.business;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.bbb.service.LotteryService;
import com.example.ccc.service.RandomNumberService;

public class SimpleLotteryService implements LotteryService {
	private RandomNumberService randomNumberService;

	public SimpleLotteryService() {
		ServiceLoader<RandomNumberService> first = ServiceLoader.load(RandomNumberService.class);
		this.randomNumberService = first.findFirst().get();
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> randomNumberService.generate(1, max)).distinct().limit(size).sorted().boxed()
				.collect(Collectors.toList());
	}

}
