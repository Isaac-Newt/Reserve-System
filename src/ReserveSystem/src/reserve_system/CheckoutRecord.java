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
}
