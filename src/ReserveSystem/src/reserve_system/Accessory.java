package reserve_system;

/*
 * Accessory: accompanies other items, object type
 * indicated by data member "Name"
 */

public class Accessory extends CirculatingItem {

    private String Name;
    private String associatedType;

    public Accessory(String name, String atype,
        int bar, int dur, String loc) {
        // Super constructor
        super("Accessory", bar, dur, loc);
        this.Name = name;
        this.associatedType = atype;
    }
    
    public String getName() {
    	return this.Name;
    }

}
