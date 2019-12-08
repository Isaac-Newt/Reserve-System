package reserve_system;

public class Key extends CirculatingItem {

	private int roomNumber;
	
	public Key(int bar, CheckoutRecord rec, int room) {
	    // rooms are checked out for 2 hours, and are located in the key drawer
	    super(bar, 2, "Key Drawer");
	    this.roomNumber = room;
	}
	
}
