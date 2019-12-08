package reserve_system;

public abstract class CirculatingItem {
	
	// Abstract class does not define data members, only declares them
	private int Barcode;
	private int loanDuration;
	private String Location;
	private CheckoutRecord Record;
	
	public CirculatingItem(int bar, int dur, String loc) {
		// Default constructor, call from subclasses with super(parameters)
		this.Barcode = bar;
		this.loanDuration = dur;
		this.Location = loc;
	}
	
	public void setRecord(Patron patron) {
		// Use Record data member's setters to modify dueDate and patronID
	}
	
	public void checkOut(CheckoutRecord cr) {
		this.Record = cr;
	}
	
	public int getBarcode() {
		return this.Barcode;
	}
	
	public void returnItem() {
		CheckoutRecord cr = this.Record;
		Patron patron = cr.getpatron();
		// Add fine here
		//Logic:  if return date is after due date, calculate fine
		// Does this mean that each item needs to have a fine?
		patron.removeFromRecord(cr);
		this.Record = null;  // is this correct?
		//do we eliminate CheckoutRecord?  Or not worry about it?
	}
}
