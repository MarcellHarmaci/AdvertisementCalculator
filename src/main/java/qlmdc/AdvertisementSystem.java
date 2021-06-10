package main.java.qlmdc;

import java.util.List;

public interface AdvertisementSystem {
	public void registerAdvertisement(Advertisement ad);
	
	// Következı reklám megjelenítése a megadott napon.
	public void showNextAdvertisement(int dayIndex);
	
	public List<Advertisement> getAdvertisementList();
}

