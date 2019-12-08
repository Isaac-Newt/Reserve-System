package reserve_system;
import java.util.*;
public class PatronList {
	Map<Integer, Patron> Plist = new HashMap<Integer, Patron>();
	PatronList(Integer pid, Patron p){
		Plist.put(pid, p);
	}
	public Patron getPatron(Integer pi) {
		Patron p = Plist.get(pi);
		return p;
	}
	public void addPatron(Integer pid, Patron p) {
		Plist.put(pid, p);
	}
}