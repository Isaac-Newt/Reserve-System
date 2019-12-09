package reserve_system;

//import javax.swing.*;

class AssociatedItems {
    Accessory[] items;

    public void buildList(Accessory[] accessory, CheckoutRecord checkout) {
        this.items = accessory;
        //variable to hold list of strings
        String str = "";
        //loop to iterate through all the accessory items
        for (int i = 0; i < items.length; i++) {
            //creating list of strings by concatenating
            if (items[i] != null) {
                str += items[i].name + "\n";
            }
        }
        removeItemsAtCheckout(displayDialog(str)); 
    }

//    public String displayDialog(String str) {  // MY GUI
//    }

    // This function It will remove the item when ever your enter a 
    // list item in the message box
    
    public void removeItemsAtCheckout(String name) {
        boolean check = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equalsIgnoreCase(name)) {
                items[i] = null;
                check = true;
            }
        }
        if (check == true) {
            buildList(items, this.checkout);
        }
    }
}
