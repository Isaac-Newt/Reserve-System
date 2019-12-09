package reserve_system;

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
	
}