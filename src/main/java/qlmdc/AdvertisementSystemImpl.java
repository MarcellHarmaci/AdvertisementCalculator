package main.java.qlmdc;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementSystemImpl implements AdvertisementSystem {
	private List<Advertisement> ads = new ArrayList<>();
	
	@Override
	public void registerAdvertisement(Advertisement ad) {
		ads.add(ad);
	}
	
	@Override
	public void showNextAdvertisement(int dayIndex) {
		 // TODO Implement method
	}
	
	@Override
	public List<Advertisement> getAdvertisementList() {
		return ads;
	}
}
