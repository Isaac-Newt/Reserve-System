package reserve_system;

import java.util.ArrayList;

public class Bike extends CirculatingItem {
	
	private String Model;
	private ArrayList<Accessory> itemList;

	public Bike(String mod, ArrayList<Accessory> list, int bar, int dur, String loc, CheckoutRecord rec) {
		super("Bike", bar, dur, loc);
		this.Model = mod;
		this.itemList = list;
	}
	
	public void checkOut(int Barcode) {
		this.getBarcode();
	}
	
	public static void main(String[] args) {
		ArrayList bike = new ArrayList();
		bike.add("helmet");
		bike.add("key");
		System.out.println(bike);	
		
	}
	// Getters and Setters
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public ArrayList<Accessory> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Accessory> itemList) {
		this.itemList = itemList;
	}
	
	
	
}
