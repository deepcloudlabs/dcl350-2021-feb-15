import com.example.ccc.service.RandomNumberService;
import com.example.ccc.service.business.SimpleRandomNumberService;

module com.example.c {
	exports com.example.ccc.service;

	provides RandomNumberService with SimpleRandomNumberService;
}