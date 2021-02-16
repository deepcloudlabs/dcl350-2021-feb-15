package com.example.hr.domain;

import com.example.hr.infrastructure.FiatCurrencyCollector;

// Value Object
public final class FiatCurrency {
	private final String value;

	private FiatCurrency(String value) {
		this.value = value;
	}

	private static FiatCurrencyCollector fiatCurrencyCollector;
	
	
	public static void setFiatCurrencyCollector(FiatCurrencyCollector fiatCurrencyCollector) {
		FiatCurrency.fiatCurrencyCollector = fiatCurrencyCollector;
	}

	public static FiatCurrency valueOf(String value) {
		var found = fiatCurrencyCollector.getAllCurrencySymbols()
		    .stream().anyMatch(symbol-> symbol.equals(value));
		if (found)
			return new FiatCurrency(value);
		throw new IllegalArgumentException("Does not support this currency symbol");
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "FiatCurrency [value=" + value + "]";
	}
	
}
