package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.Quality;
import com.example.lottery.service.QualityLevel;

@Service
@Quality(QualityLevel.SIMPLE)
// @Scope("singleton") // default
//@Scope("request")
//@RequestScope
@ConditionalOnProperty(value = "service.type", havingValue = "simple")
@Profile({"dev","test"})
// -Dspring.profiles.active=dev
public class SimpleLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return ThreadLocalRandom.current()
				                .ints(1, max)
				                .distinct()
				                .limit(size)
				                .sorted()
				                .boxed()
				                .collect(Collectors.toList());
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return IntStream.range(0, column)
				        .mapToObj(i -> this.draw(max, size))
				        .collect(Collectors.toList());
	}

}
