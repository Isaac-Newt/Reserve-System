package reserve_system;
import java.util.ArrayList;
import java.util.GregorianCalendar;

//December 6.  EB added attributes, constructor, setters and getters for all fields except for Record
// Also added methods for CheckoutRecord and addToRecord.
// This required changing the due date field of Circulating Item to GregorianCalendar type.

public abstract class Patron {
	private int ID;
	private String lastName;
	private String firstName;
	private double fineBalance;
	private boolean bikeWaiver;
	private String email;
	private int phoneNumber;
	private ArrayList<CheckoutRecord> Record;
	
	// Initialization assumes zero fine balance, false bike waiver, nothing checked out
	public Patron (int i, String ln, String fn, String e, int p) {
		this.ID = i;
		this.lastName = ln;
		this.firstName = fn;
		this.email = e;
		this.phoneNumber = p;
		this.fineBalance = 0.0;
		this.bikeWaiver = false;
		this.Record = new ArrayList<CheckoutRecord>(); 
	}
	
	public CheckoutRecord checkOut(CirculatingItem ci){
		//create due date as type GregorianCalendar
		GregorianCalendar dueDate = new GregorianCalendar();
		//set due date as current time plus loan duration (hours)
		dueDate.set(GregorianCalendar.HOUR, (dueDate.get(GregorianCalendar.HOUR)+ ci.getLoanDuration()));  
		CheckoutRecord r = new CheckoutRecord(this.ID, ci, dueDate);
		return r;
	}
	
	public void addToRecord(CheckoutRecord r) {
		this.Record.add(r);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getFineBalance() {
		return fineBalance;
	}


	public boolean isBikeWaiver() {
		return bikeWaiver;
	}

	public void setBikeWaiver(boolean bikeWaiver) {
		this.bikeWaiver = bikeWaiver;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
