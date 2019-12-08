package reserve_system;

import java.util.GregorianCalendar;

public class CheckoutRecord {
	private Patron patron;  // change Dec 7:  why not store patron, rather than ID?
	private CirculatingItem Item;
	private GregorianCalendar DueDate = new GregorianCalendar();  // change to allow use of dates
	
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
	
	public CirculatingItem getItem(){
		return this.Item;
	}
	@Override
	public String toString() {
		String nstring = new String();
		String dstring = new String();
		nstring = this.patron.getID() + ", "+this.Item.getBarcode();
		dstring = " Due date: "+DueDate.get(GregorianCalendar.YEAR)+" "+DueDate.get(GregorianCalendar.MONTH)+ " ";
		dstring = dstring + DueDate.get(GregorianCalendar.DATE) + " @ "+DueDate.get(GregorianCalendar.HOUR)+this.DueDate.get(GregorianCalendar.MINUTE);
		return nstring + dstring;
	}	
	
}