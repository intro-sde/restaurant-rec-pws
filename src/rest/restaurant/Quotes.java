package rest.restaurant;

import java.util.Random;

public class Quotes {
	
	public static String getRandomQuotes() throws Exception {
		
		String quotes[] = {"Food is an important part of a balanced diet. (Fran Lebowitz)",
				"A balanced diet is a cookie in each hand. (Barbara Johnson)",
				"Success in life is to eat what you like and let the food fight it out inside. (Mark Twain)",
				"Life is a combination of magic and pasta. (Federico Fellini)",
				"First we eat and then we do everything else. (M.F.K. Fisher)",
				"People who love to eat are always the best people. (Julia Child)"};
		
		String quote =quotes[getRandomNumberInRange(0,5)];
		
		return quote;
	}
	
	
	private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	
}
