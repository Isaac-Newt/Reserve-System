package reserve_system;

import java.util.ArrayList;

public class Bike extends CirculatingItem {
	
	private String Model;
	private ArrayList<Accessory> itemList;

    // Constructor
	public Bike(String mod, ArrayList<Accessory> list, int bar, int dur, String loc) {
		super("Bike", bar, dur, loc);
		this.Model = mod;
		this.itemList = list;
	}
	
	public ArrayList<Accessory> getItemList() {
		return itemList;
	}
	
	public String getModel() {
	    reuturn this.Model;
	}
	
}
