package main.java.qlmdc;

import java.util.Hashtable;

public interface Advertisement {
	public int getMaxAppearance();
	
	public double getWeight();
	
	// Sum of appearances on days (dayIndex - numberOfDays, dayIndex]
	public int lastAppearance(int dayIndex, int numberOfDays);
	
	public void showAdvertisement();
	
	// Hashtable<dayIndex, appearancesAtDay>
	public Hashtable<Integer,Integer> getAllAppearances();
}
