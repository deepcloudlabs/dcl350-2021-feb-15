import com.example.bbb.service.LotteryService;
import com.example.bbb.service.business.SimpleLotteryService;
import com.example.ccc.service.RandomNumberService;

module com.example.b {
	exports com.example.bbb.service;

	provides LotteryService with SimpleLotteryService;

	requires com.example.c;
	requires java.base;

	uses RandomNumberService;
}