package reserve_system;
<<<<<<< HEAD

import java.util.*;

public class PatronList {
	
	Map<Integer, Patron> patronList = new HashMap<Integer, Patron>();
	
	// Constructor
	PatronList(Integer patronID, Patron patron){
		patronList.put(patronID, patron);
	}
	
	// Getter
	public Patron getPatron(Integer patronID) {
		Patron patron = patronList.get(patronID);
		return patron;
	}
	
	// Setter of sorts
	public void addPatron(Integer patronID, Patron patron) {
		patronList.put(patronID, patron);
	}
	
=======
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
>>>>>>> da3c78499a1ef0451c2f5a3391f6be9475ca23e8
}