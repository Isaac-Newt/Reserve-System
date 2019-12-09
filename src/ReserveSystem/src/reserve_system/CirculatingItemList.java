package reserve_system;

import java.util.*;

public class CirculatingItemList {

	Map<Integer, CirculatingItem> itemList = new HashMap<Integer, CirculatingItem>();
	
	// Constructor
	CirculatingItemList(Integer itemBarCode, CirculatingItem item){
		itemList.put(itemBarCode, item);
	}
	
	// Getter
	public CirculatingItem getItem(Integer itemBarCode) {
		CirculatingItem item = itemList.get(itemBarCode);
		return item;
	}
	
	// Setter of sorts, probably won't make available through the UI
	public void addItem(Integer itemBarCode, CirculatingItem item) {
		itemList.put(itemBarCode, item);
	}
	
}
