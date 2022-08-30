package com.sjoedwards.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Create an array of strings
	private String[] data = {
			"Beware of the wolf in sheeps clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		// Pick a random string out of this array
		
		// Random number based on the size of the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
