package reserve_system;

import java.util.ArrayList;

public class Camera extends CirculatingItem {
	
	private String Model;
	private ArrayList<Accessory> itemList;
	
	public Camera(String mod, ArrayList<Accessory> list, int bar, int dur, String loc, CheckoutRecord rec) {
		super("Camera", bar, dur, loc);
		this.Model = mod;
		this.itemList = list;
	}
	
	public void checkOut(int Barcode) {
		this.getBarcode();
	}
	
	public static void main(String[] args) {
		ArrayList camera = new ArrayList();
		camera.add("SSD");
		camera.add("Battery");
		camera.add("Charger");
		
		System.out.println(camera);	
	}
}
//	@Override
//	public void checkOut(CheckoutRecord cr ) {
//		this.Record = cr;
