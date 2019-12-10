package reserve_system;

public class Accessory extends CirculatingItem {

    private String Name;
    private CirculatingItem associatedItem;

    public Accessory(String name, CirculatingItem asd,
        int bar, int dur, String loc, CheckoutRecord rec) {
        // Super constructor
        super(bar, dur, loc);
        this.Name = name;
        this.associatedItem = asd;
    }
    
    public String getName() {
    	return this.Name;
    }

}
