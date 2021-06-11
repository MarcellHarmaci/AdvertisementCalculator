package main.java.qlmdc;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Random random = new Random();
		AdvertisementSystem system = new AdvertisementSystemImpl(random, 3);
		
		// Register ads
		for (int i = 0; i < 20; i ++) {
			Advertisement ad1 = new AdvertisementImpl(
					1,
					0.7,
					"70% ad #" + i
			);
			Advertisement ad2 = new AdvertisementImpl(
					1,
					0.5,
					"50% ad #" + i
			);
			Advertisement ad3 = new AdvertisementImpl(
					1,
					0.3,
					"30% ad #" + i
			);
			system.registerAdvertisement(ad1);
			system.registerAdvertisement(ad2);
			system.registerAdvertisement(ad3);
		}
		
		// Show all ads on day 0
		for (int i = 0; i < 60; i ++) {
			system.showNextAdvertisement(0);
		}
		
		// Show all ads on day 3
		for (int i = 0; i < 60; i ++) {
			system.showNextAdvertisement(3);
		}
		
		// Last show call throws IllegalStateException with custom message
		// All the ads has been shown the max times at this point
		system.showNextAdvertisement(3);
	}
}
