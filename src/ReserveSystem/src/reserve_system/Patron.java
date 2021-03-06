package reserve_system;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/*
 * This class provides for the creation of patron objects.
 */

// December 6.  EB added attributes, constructor, setters and getters for all fields except for Record
// Also added methods for CheckoutRecord and addToRecord.
// This required changing the due date field of Circulating Item to GregorianCalendar type.

public class Patron {
	private int ID;
	// Replaces subclasses Community, Student, Faculty
	private String Type;
	private String lastName;
	private String firstName;
	private double fineBalance;
	private boolean bikeWaiver;
	private String email;
	private int phoneNumber;
	private ArrayList<CheckoutRecord> Record;
	
	// Initialization assumes zero fine balance, false bike waiver, nothing checked out
	public Patron (int i, String t, String ln, String fn, String e, int p) {
		this.ID = i;
		this.Type = t;
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
		dueDate.set(GregorianCalendar.HOUR_OF_DAY, (dueDate.get(GregorianCalendar.HOUR_OF_DAY)+ ci.getLoanDuration()));  
		CheckoutRecord r = new CheckoutRecord(this, ci, dueDate);
		addToRecord(r);  //Now implemented automatically with creation of record
		ci.checkOut(r); //Calls Checkout function in circulating item to store checkout record
		return r;
	}
	
	public String listCheckoutItems() {
		String istring = "";
		String item = "";
		String dd = "";	
		for(CheckoutRecord cr:this.Record) {
			istring = istring + cr.toString() + "\n";
		}
		return istring;
	}
	
	public void addToRecord(CheckoutRecord r) {
		this.Record.add(r);
	}
	
	public void removeFromRecord(CheckoutRecord r) {
		this.Record.remove(r);
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

	public String getType() {
		return Type;
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
	
	public void addToFine(double fine) {
		this.fineBalance = this.fineBalance + fine;
	}
	
	public void payFine(double payment) {
		this.fineBalance = this.fineBalance - payment;
	}
	
}
