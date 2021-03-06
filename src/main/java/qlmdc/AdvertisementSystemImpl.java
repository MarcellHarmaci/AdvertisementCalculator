package main.java.qlmdc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class AdvertisementSystemImpl implements AdvertisementSystem {
	private Random random;
	private int numberOfDays;
	
	private List<Advertisement> ads = new ArrayList<>();
	private int index = 0;
	
	public AdvertisementSystemImpl(Random random, int numberOfDays) {
		this.random = random;
		this.numberOfDays = numberOfDays;
	}
	
	@Override
	public void registerAdvertisement(Advertisement ad) {
		ads.add(ad);
	}
	
	@Override
	public void showNextAdvertisement(int dayIndex) {
		if (ads == null || ads.isEmpty())
			throw new IllegalStateException("There are no ads registered, therefore no ad to show.");
		
		if (!canAnyAdBeShownAtDay(dayIndex))
			throw new IllegalStateException("Non of the registered ads can be shown at the given day.");
			
		// Find an ad to show
		Advertisement ad = ads.get(index);
		while ( !canAdBeShown(ad, dayIndex, numberOfDays) ||
				ad.getWeight() < random.nextDouble()
		) {
			incrementIndex();
			ad = ads.get(index);
		}
		
		// Show the ad
		showAd(ad, dayIndex);
		
		incrementIndex();
	}
	
	private void incrementIndex() {
		index++;
		
		if (index == ads.size())
			index = 0;
	}
	
	// TODO Implement method
	private boolean canAnyAdBeShownAtDay(int dayIndex) {
		for (Advertisement ad : ads) {
			if (ad.lastAppearance(dayIndex, numberOfDays) < ad.getMaxAppearance())
				return true;
		}
		return false;
	}
	
	private boolean canAdBeShown(Advertisement ad, int dayIndex, int numberOfDays) {
		return ad.lastAppearance(dayIndex, numberOfDays) < ad.getMaxAppearance();
	}
	
	private void showAd(Advertisement ad, int dayIndex) {
		// Show ad
		ad.showAdvertisement();
		
		// Increment ad's appearance hash
		Hashtable<Integer, Integer> adAppearances = ad.getAllAppearances();
		Integer appearancesAtDay = adAppearances.get(dayIndex);
		
		if (appearancesAtDay == null) {
			appearancesAtDay = 1;
		} else {
			appearancesAtDay++;
		}
		
		adAppearances.put(dayIndex, appearancesAtDay);
	}
	
	@Override
	public List<Advertisement> getAdvertisementList() {
		return ads;
	}
}
