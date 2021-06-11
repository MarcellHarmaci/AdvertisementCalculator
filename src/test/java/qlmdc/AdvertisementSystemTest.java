package test.java.qlmdc;

import main.java.qlmdc.AdvertisementImpl;
import main.java.qlmdc.AdvertisementSystem;
import main.java.qlmdc.AdvertisementSystemImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdvertisementSystemTest {
	private AdvertisementSystem system;
	private Random random;
	private final int NUMBER_OF_DAYS = 3;
	
	@BeforeEach
	public void initSystem() {
		random = new Random(42);
		system = new AdvertisementSystemImpl(random, NUMBER_OF_DAYS);
	}
	
	@Test
	public void testAdListEmpty() {
		assertThrows(
				IllegalStateException.class,
				() -> system.showNextAdvertisement(0)
		);
	}
	
	@Test
	public void testNoMoreAdToShow() {
		system.registerAdvertisement(new AdvertisementImpl(
				2,
				50,
				"Test ad"
		));
		
		assertDoesNotThrow(() -> system.showNextAdvertisement(0));
		assertDoesNotThrow(() -> system.showNextAdvertisement(0));
		
		assertThrows(
				IllegalStateException.class,
				() -> system.showNextAdvertisement(0)
		);
	}
	
	@Test
	public void testHappyPath() {
		system.registerAdvertisement(new AdvertisementImpl(
				2,
				50,
				"Test ad 1"
		));
		system.registerAdvertisement(new AdvertisementImpl(
				2,
				50,
				"Test ad 2"
		));
		
		for (int i = 0; i < 4; i++) {
			assertDoesNotThrow(() -> system.showNextAdvertisement(0));
		}
		
		for (int i = 0; i < 4; i++) {
			assertDoesNotThrow(() -> system.showNextAdvertisement(3));
		}
	}
}
