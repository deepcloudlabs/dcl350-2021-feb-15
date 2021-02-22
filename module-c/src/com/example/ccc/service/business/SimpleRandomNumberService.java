package com.example.ccc.service.business;

import java.security.SecureRandom;
import java.util.Random;

import com.example.ccc.service.RandomNumberService;

public class SimpleRandomNumberService implements RandomNumberService {

	private Random random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return min + random.nextInt(max - min + 1);
	}

}
