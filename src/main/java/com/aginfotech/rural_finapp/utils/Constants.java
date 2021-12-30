package com.aginfotech.rural_finapp.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	static {
		Map<String, Long> loanInterest = new HashMap<>();
		loanInterest.put("Two Wheeler Loan", 10L);
		loanInterest.put("Car Loan", 12L);
		loanInterest.put("Gold Loan", 8L);
		loanInterest.put("Personal Loan", 14L);
		loanInterest.put("Default", 9L);
		loanInterestMap = Collections.unmodifiableMap(loanInterest);
	}

	public static final Map<String, Long> loanInterestMap;
}
