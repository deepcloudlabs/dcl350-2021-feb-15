package com.example.lottery.service.business;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.Quality;
import com.example.lottery.service.QualityLevel;

@Service
@Quality(QualityLevel.FAST)
@ConditionalOnProperty(value = "service.type", havingValue = "fast")
public class FastLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return List.of(1,2,3,4,5,6);
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return List.of(List.of(1,2,3,4,5,6),List.of(7,8,9,10,11,12));
	}

}
