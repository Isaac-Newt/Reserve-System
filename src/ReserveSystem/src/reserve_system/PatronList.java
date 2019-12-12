package reserve_system;

import java.util.*;

/*
 * This class provides a place to store all instances of Patron.
 * It is utilized by the UserInterface class to retrieve items as using
 * their associated ID
 */

public class PatronList {
	
	Map<Integer, Patron> patronList = new HashMap<Integer, Patron>();
	
	// Constructor
	PatronList(Integer patronID, Patron patron){
		patronList.put(patronID, patron);
	}
	
	// Getter (based on ID)
	public Patron getPatron(Integer patronID) {
		Patron patron = patronList.get(patronID);
		return patron;
	}
	
	// Setter of sorts
	public void addPatron(Integer patronID, Patron patron) {
		patronList.put(patronID, patron);
	}
	
}
