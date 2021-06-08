package main.java.qlmdc;

import java.util.List;

public interface AdvertisementSystem {
	// Reklám regisztrálása.
	public void registerAdvertisement(Advertisement ad);
	
	// Következı reklám megjelenítése a megadott napon.
	public void showNextAdvertisement(int dayIndex);
	
	// List of ads
	public List<Advertisement> getAdvertisementList();
}

