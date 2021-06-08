package main.java.qlmdc;

import java.util.Hashtable;

public class AdvertisementImpl implements Advertisement {
	private int maxAppearance = 0;
	private int cntAppearances = 0;
	private double weight = 0.0;
	private String content = "Ad text not specified";
	private Hashtable<Integer, Integer> allAppearances = new Hashtable<>();
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public int getMaxAppearance() {
		return maxAppearance;
	}
	
	@Override
	public Hashtable<Integer, Integer> getAllAppearances() {
		return allAppearances;
	}
	
	@Override
	public int lastAppearance(int dayIndex, int numberOfDays) {
		// TODO Implement method
		return 0;
	}
	
	// TODO
	//  Comply with specifications!
	//  Day index is unknown and I think it should affect if the ad can be shown or not
	@Override
	public void showAdvertisement() {
		if (cntAppearances < maxAppearance) {
			System.out.println(content);
			cntAppearances++;
		} else {
			throw new IllegalStateException("This ad already reached it's maximum number of appearances");
		}
	}
}
