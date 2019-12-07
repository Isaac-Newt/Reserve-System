package reserve_system;
import java.util.GregorianCalendar;
public class CheckoutRecord {
	private int PatronID;
	private CirculatingItem Item;
	private GregorianCalendar DueDate = new GregorianCalendar();  // change to allow use of dates
	
	public CheckoutRecord(int pi, CirculatingItem i, GregorianCalendar dd) {
		this.PatronID = pi;
		this.Item = i;
		this.DueDate = dd;
	}
	@Override
	public String toString() {
		String nstring = new String();
		String dstring = new String();
		nstring = this.PatronID + ", "+this.Item.getBarcode();
		dstring = " Due date: "+DueDate.get(GregorianCalendar.YEAR)+" "+DueDate.get(GregorianCalendar.MONTH)+ " ";
		dstring = dstring + DueDate.get(GregorianCalendar.DATE) + " @ "+DueDate.get(GregorianCalendar.HOUR)+this.DueDate.get(GregorianCalendar.MINUTE);
		return nstring + dstring;
	}	
}
