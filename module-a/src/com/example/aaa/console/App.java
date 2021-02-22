package com.example.aaa.console;

import java.util.ServiceLoader;

import com.example.bbb.service.LotteryService;

public class App {

	public static void main(String[] args) {
		ServiceLoader<LotteryService> loader = ServiceLoader.load(LotteryService.class);
		loader.findFirst().ifPresent(service -> service.draw(50, 6).forEach(System.out::println));
	}

}
