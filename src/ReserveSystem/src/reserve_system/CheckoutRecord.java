package reserve_system;

import java.util.GregorianCalendar;

/*
 * This class interfaces between a Patron and a CirculatingItem,
 * storing information about what is checked out to whom, as well
 * as the due date/time. It is a component of both Patron and
 * CirculatingItem, so that each knows its loan information.
 */

public class CheckoutRecord {

	private Patron patron;
	private CirculatingItem Item;
	private GregorianCalendar DueDate = new GregorianCalendar();  // change to allow use of dates
	
	// Constructor
	public CheckoutRecord(Patron p, CirculatingItem i, GregorianCalendar dd) {
		this.patron = p;
		this.Item = i;
		this.DueDate = dd;
	}
	
	public Patron getpatron(){
		return this.patron;
	}
	
	public GregorianCalendar getDueDate(){
		return this.DueDate;
	}
	
	public void setDueDate(GregorianCalendar d) {
		this.DueDate = d;
	}
	
	public CirculatingItem getItem(){
		return this.Item;
	}
	
	@Override
	public String toString() {
		String nstring = new String();
		String dstring = new String();
		nstring = "Patron ID:" + this.patron.getID() + ", Item type: "+this.Item.getType()+", Item barcode: "+this.Item.getBarcode();
		dstring = " Due date: "+DueDate.get(GregorianCalendar.YEAR)+" "+DueDate.get(GregorianCalendar.MONTH)+ " ";
		dstring = dstring + DueDate.get(GregorianCalendar.DATE) + " @ "+DueDate.get(GregorianCalendar.HOUR)+this.DueDate.get(GregorianCalendar.MINUTE);
		return nstring + dstring;
	}	
	
}
