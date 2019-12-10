package reserve_system;

public class Key extends CirculatingItem {

	private int roomNumber;
	
	public Key(int bar, int room) {
	    // rooms are checked out for 2 hours, and are located in the key drawer
	    super("Key", bar, 2, "Key Drawer");
	    this.roomNumber = room;
	}
	
}
