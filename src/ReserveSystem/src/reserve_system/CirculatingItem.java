package reserve_system;

public abstract class CirculatingItem {
	
	// Abstract class does not define data members, only declares them
	private String Type;
	private int Barcode;
	private int loanDuration;
	private String Location;
	private CheckoutRecord Record;
	
	public CirculatingItem(String type, int bar, int dur, String loc) {
		// Default constructor, call from subclasses with super(parameters)
		this.Type = type;
		this.Barcode = bar;
		this.loanDuration = dur;
		this.Location = loc;
	}
	
	public void checkOut(CheckoutRecord cr) {
		this.Record = cr;
	}
	
	public void returnItem() {
		CheckoutRecord cr = this.Record;
		Patron patron = cr.getpatron();
		// Add fine here
		// Logic:  if return date is after due date, calculate fine
		// Does this mean that each item needs to have a fine?
		patron.removeFromRecord(cr);
		this.Record = null;  // is this correct?
		//do we eliminate CheckoutRecord?  Or not worry about it?
	}
	
	public boolean isAvailable() {
		boolean Available = true;
		if (this.Record != null) Available = false;
		return Available;
	}
	
	public int getBarcode() {
		return this.Barcode;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public String getLocation() {
		return Location;
	}

	public CheckoutRecord getRecord() {
		return Record;
	}
	
}
