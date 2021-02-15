package com.example.lottery.service;

import java.util.List;

// Ctrl + Shift + F : Format
// Ctrl + Shift + O : Organize import
public interface LotteryService {
	List<Integer> draw(int max, int size);

	List<List<Integer>> draw(int max, int size, int column);
}
