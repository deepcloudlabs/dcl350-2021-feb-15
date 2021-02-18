package com.example.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SimpleLotteryService {

	@Async
	public CompletableFuture<List<Integer>> draw(int max,int size){
		return CompletableFuture.completedFuture(ThreadLocalRandom.current().ints(1,max).distinct()
				          .limit(size).sorted()
				          .boxed().collect(Collectors.toList()));
	}
}
