package reserve_system;

public class Bike extends CirculatingItem implements ComplexItem {
	
	private String Model;
	// Yet to implement list behavior here
	// private Accessory itemList;

	public Bike(String mod, int bar, int dur, String loc, CheckoutRecord rec) {
		super(bar, dur, loc, rec);
		this.Model = mod;
	}
	
}
