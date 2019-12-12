package reserve_system;

import java.util.*;

/*
 * This class provides a place to store all instances of CirculatingItem
 * It is utilized by the UserInterface class to retrieve items as using
 * their associated barcode
 */

public class CirculatingItemList {

	Map<Integer, CirculatingItem> itemList = new HashMap<Integer, CirculatingItem>();
	
	// Constructor
	CirculatingItemList(Integer itemBarCode, CirculatingItem item){
		itemList.put(itemBarCode, item);
	}
	
	// Getter (based on barcode)
	public CirculatingItem getItem(Integer itemBarCode) {
		CirculatingItem item = itemList.get(itemBarCode);
		return item;
	}
	
	// Setter of sorts, won't make available through the UI
	public void addItem(Integer itemBarCode, CirculatingItem item) {
		itemList.put(itemBarCode, item);
	}
	
}
