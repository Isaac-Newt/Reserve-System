package reserve_system;

public class Laptop extends CirculatingItem {
	
	private String Model;

	public Laptop(String mod, int bar, int dur, String loc, CheckoutRecord rec) {
		super("Laptop", bar, dur, loc);
		this.Model = mod;
	}

}
