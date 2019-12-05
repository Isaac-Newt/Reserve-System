package reserve_system;

public abstract class CirculatingItem {
	
	// Abstract class does not define data members, only declares them
	private int Barcode;
	private int loanDuration;
	private String Location;
	private CheckoutRecord Record;
	
	public CirculatingItem(int bar, int duration, String loc, CheckoutRecord rec) {
		// Default constructor, call from subclasses with super(parameters)
		this.Barcode = bar;
		this.loanDuration = duration;
		this.Location = loc;
		this.Record = rec;
	}
	
	public void setRecord(Patron patron) {
		// Use Record data member's setters to modify dueDate and patronID
	}
	
}
