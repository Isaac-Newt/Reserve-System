package reserve_system;

import java.util.ArrayList;

public class Camera extends CirculatingItem {
	
	private String Model;
	private ArrayList<Accessory> itemList;
	
	// Constructor
	public Camera(String mod, ArrayList<Accessory> list, int bar, int dur, String loc) {
		super("Camera", bar, dur, loc);
		this.Model = mod;
		this.itemList = list;
	}
	
	public ArrayList<Accessory> getItemList() {
		return itemList;
	}
	
	public String getModel() {
	    return this.Model;
	}

}
