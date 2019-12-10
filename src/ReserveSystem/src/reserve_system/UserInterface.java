package reserve_system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class UserInterface {
	
	JMenu Circulation, PatronRecords;  //Menu 
    JMenuItem i1, i2, i3, i4, i5, i6; //Menu Items 
    
    // Patron and CirculatingItem Lists
    PatronList patronList;
    CirculatingItemList itemList;
    
    UserInterface(PatronList npl, CirculatingItemList cil){ //we must have instances of patronlist, circitemlist.
	    JFrame f= new JFrame("Reserve Circulation System");  
	    
	    JMenuBar mb=new JMenuBar(); //Menu Bar
		Circulation = new JMenu("Circulation");
		PatronRecords = new JMenu("Patron records");
		i1=new JMenuItem("Checkout Item");
		i2=new JMenuItem("Return Item");
		i3=new JMenuItem("Search for Item");
		i4=new JMenuItem("Add Patron");
		i5=new JMenuItem("Pay fine");
		i6=new JMenuItem("List checked out items");
		Circulation.add(i1);
		Circulation.add(i2);
		Circulation.add(i3);
		PatronRecords.add(i4);
		PatronRecords.add(i5);
		PatronRecords.add(i6);
		mb.add(Circulation);
		mb.add(PatronRecords);
		f.setJMenuBar(mb);  //Adding MenuBar to frame

        f.setSize(800,800);  
        f.setLayout(null);  
        f.setVisible(true); 
        
        i1.addActionListener((ActionEvent e) -> {
        	// pi String is PatronID
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please enter patron ID:\n",
                    "Item checkout",
                    JOptionPane.PLAIN_MESSAGE); 
        	
        	// If we wanted to be fancy, we could automatically list checked out items here.
        	// Need to look up Patron, check for fine if community member
        	
        	Integer patronID = Integer.valueOf(pi);
        	Patron patron = npl.getPatron(patronID);
        	
        	// bc String is item barcode
        	String barcode = (String)JOptionPane.showInputDialog(null,
                    "Please enter item barcode:\n",
                    "Item checkout",
                    JOptionPane.PLAIN_MESSAGE); 
        	
        	Integer itemBarCode = Integer.valueOf(barcode);
        	CirculatingItem item = cil.getItem(itemBarCode);
        	
        	// Check out the item to the selected patron
        	patron.checkOut(item);
        });
        
        i2.addActionListener((ActionEvent e) -> {
        	String barcode = (String)JOptionPane.showInputDialog(null,
                    "Please enter item barcode:\n",
                    "Item return",
                    JOptionPane.PLAIN_MESSAGE);  
        	
        	// Look up item, initiate checkIn function
    		Integer itemBarCode = Integer.valueOf(barcode);
    		CirculatingItem item = cil.getItem(itemBarCode);
    		item.returnItem();
        });
        
        i3.addActionListener((ActionEvent e) -> {
        	// need to bring up pane for data entry for search
        	JOptionPane.showMessageDialog(null, "Display dialog for search", "Search for circulating item",  1);
        });
        
        i4.addActionListener((ActionEvent e) -> {
        	PatronInterface patInt = new PatronInterface(f, npl);
        });
        
        i5.addActionListener((ActionEvent e) -> {
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please enter patron's ID:\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE);  
        	//Need to look up Patron using ID, display current fine balance, 
        	//Ask for payment on balance, and adjust balance
        	Integer pid = Integer.valueOf(pi);
        	Patron patron = npl.getPatron(pid);
        	String pmnt = (String)JOptionPane.showInputDialog(null,
                    "Current fine balance is: "+patron.getFineBalance()+".  Enter payment amount.\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE); 
        	double pmntd = Double.valueOf(pmnt);
        	patron.payFine(pmntd);
        });
        
        i6.addActionListener((ActionEvent e) -> {
        	String pi = (String)JOptionPane.showInputDialog(null,
        			"Please enter patron's ID:\n",
        			"List checked out items",
                    JOptionPane.PLAIN_MESSAGE);     
        	Integer pid = Integer.valueOf(pi);
        	Patron patron = npl.getPatron(pid);
        	String ilist = "";
        	ilist = patron.listCheckoutItems();
        	System.out.println(ilist);
       });
         
  		
    }
	public static void main(String[] args) {
		Patron o1 = new Patron(101, "Faculty", "Joe", "Smith", "js@123.com", 4555555);
		Patron o2 = new Patron(102, "Student", "Johan", "Schmidt", "js2@123.com", 3555555);
		Patron o3 = new Patron(103, "Community", "Joseph", "Smith", "js3@123.com", 2555555);
		PatronList npl = new PatronList(101, o1);
		npl.addPatron(102,o2);
		npl.addPatron(103, o3);
		o3.addToFine(5.00);
		Key k1 = new Key(1001, 102);
		Key k2 = new Key(1002, 103);
		CirculatingItemList cil = new CirculatingItemList(1001, k1);
		cil.addItem(1002, k2);
		new UserInterface(npl, cil);
	}

}
