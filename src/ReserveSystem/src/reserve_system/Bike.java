package reserve_system;

import java.util.ArrayList;

public class Bike extends CirculatingItem implements ComplexItem {
	
	private String Model;
	private ArrayList<Accessory> itemList;

	public Bike(String mod, ArrayList<Accessory> list, int bar, int dur, String loc, CheckoutRecord rec) {
		super(bar, dur, loc, rec);
		this.Model = mod;
		this.itemList = list;
	}
	
}
