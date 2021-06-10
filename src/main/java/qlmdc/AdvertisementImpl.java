package main.java.qlmdc;

import java.util.Hashtable;

public class AdvertisementImpl implements Advertisement {
	private int maxAppearance = 0;
	private double weight = 0.0;
	private String content = "No content";
	private Hashtable<Integer, Integer> allAppearances = new Hashtable<>();
	
	@Override
	public int getMaxAppearance() {
		return maxAppearance;
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public int lastAppearance(int dayIndex, int numberOfDays) {
		int sum = 0;
		
		for (int i = dayIndex; i > dayIndex - numberOfDays; i--) {
			Integer appearancesAtDay = allAppearances.get(i);
			
			if (appearancesAtDay != null)
				sum += appearancesAtDay;
		}
		
		return sum;
	}
	
	@Override
	public void showAdvertisement() {
		System.out.println(content);
	}
	
	@Override
	public Hashtable<Integer, Integer> getAllAppearances() {
		return allAppearances;
	}
	
}
