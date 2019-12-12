package reserve_system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import javax.swing.*; 
public class UserInterface {
	
	JMenu Circulation, PatronRecords;  //Menu 
    JMenuItem i1, i2, i3, i4, i5, i6, i7; //Menu Items 
    
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
		i7 = new JMenuItem("Change due date");
		Circulation.add(i1);
		Circulation.add(i2);
		Circulation.add(i3);
		Circulation.add(i7);
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
        	Double fb = patron.getFineBalance();
        	String pt = patron.getType();
        	if (fb > 0 & pt.equals("Community")) {
        		String estring = "Patron must pay fine balance.  Current balance: $" + patron.getFineBalance();
        			JOptionPane.showMessageDialog(null, estring);
        	}
        	else {
	        	// bc String is item barcode
	        	String barcode = (String)JOptionPane.showInputDialog(null,
	                    "Please enter item barcode:\n",
	                    "Item checkout",
	                    JOptionPane.PLAIN_MESSAGE); 
	        	
	        	Integer itemBarCode = Integer.valueOf(barcode);
	        	CirculatingItem item = cil.getItem(itemBarCode);
	        	System.out.println(item);
	        	
        		        // Check out the item to the selected patron
	        		patron.checkOut(item);
	        		if (item.getType().equals("Bike")) {
	        		
	        			Bike bike = (Bike) item;
	        			AssociatedItems ats = new AssociatedItems(f, bike, cil);
	        		}
	        		if (item.getType().equals("Camera")) {
	        			System.out.println("Hey!");
	        			Camera camera = (Camera) item;
	        			AssociatedItems ats = new AssociatedItems(f, camera, cil);
	        		}
	        		String cstring = patron.getFirstName() + " " + patron.getLastName() + " checked out item ID " +barcode;
	        		JOptionPane.showMessageDialog(null, cstring);
        	}
	    });
        
        i2.addActionListener((ActionEvent e) -> {
        	String barcode = (String)JOptionPane.showInputDialog(null,
                    "Please enter item barcode:\n",
                    "Item return",
                    JOptionPane.PLAIN_MESSAGE);  
        	
        	// Look up item, initiate checkIn function
    		Integer itemBarCode = Integer.valueOf(barcode);
    		CirculatingItem item = cil.getItem(itemBarCode);
    		CheckoutRecord cr = item.getRecord();
    		Patron patron = cr.getpatron();
    		GregorianCalendar duedate = cr.getDueDate();
    		GregorianCalendar ctime = new GregorianCalendar();
    		int overdue = ctime.get(GregorianCalendar.HOUR_OF_DAY) - duedate.get(GregorianCalendar.HOUR_OF_DAY);
    		if (overdue > 0) {
    			double fine = overdue * .25;
    			String fstring = "Item overdue by " + overdue + "hours.  Fine added:  $"+fine;
    			patron.addToFine(fine);
    			JOptionPane.showMessageDialog(null, fstring);
    		}
    		item.returnItem();
        });
        
        i3.addActionListener((ActionEvent e) -> {
        	// need to bring up pane for data entry for search
        	String barcode = (String) JOptionPane.showInputDialog(null, 
        			"Please enter item barcode:\n",
        			"Item search",
        			JOptionPane.PLAIN_MESSAGE);
        	
        	Integer itemBarCode = Integer.valueOf(barcode);
        	CirculatingItem item = cil.getItem(itemBarCode);
        	boolean isAvailable = item.isAvailable();
        	
        	String message = "";
        	if (isAvailable) {
        		message = "Item " +item.getType()+" "+ itemBarCode + " is available";
        	}
        	else {
        		message = "Item " + item.getType() + " " + itemBarCode + " is not available";
        	}
        	JPanel clisth = new JPanel();
        	JTextField clist = new JTextField();
        	clist.setText(message);
        	clisth.add(clist);
        	
        	JOptionPane.showMessageDialog(null, clisth);
        });
        
        i4.addActionListener((ActionEvent e) -> {
        	PatronInterface patInt = new PatronInterface(npl, f);
		f.repaint();  // added eb
        });
        
        i5.addActionListener((ActionEvent e) -> {
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please enter patron's ID:\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE);  
        	
        	// Need to look up Patron using ID, display current fine balance, 
        	// Ask for payment on balance, and adjust balance
        	Integer pid = Integer.valueOf(pi);
        	Patron patron = npl.getPatron(pid);
        	
        	String pmnt = (String)JOptionPane.showInputDialog(null,
                    "Current fine balance is: "+patron.getFineBalance()+".  Enter payment amount.\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE);
        	
        	double pmntd = Double.valueOf(pmnt);
        	patron.payFine(pmntd);
        	String nfine = "New fine balance is $" + patron.getFineBalance();
        	JOptionPane.showMessageDialog(null, nfine);
        	
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
        	
        	// Display message in JOptionPane Dialog box
        	JOptionPane.showMessageDialog(null, ilist);
       });
         
        i7.addActionListener((ActionEvent e) -> {
        	String ci = (String)JOptionPane.showInputDialog(null,
        			"Please enter item ID:\n",
        			"Change due date",
                    JOptionPane.PLAIN_MESSAGE);
        	
        	Integer cid = Integer.valueOf(ci);
        	CirculatingItem cio = cil.getItem(cid);
        	CheckoutRecord cor = cio.getRecord();
        	GregorianCalendar dueDate = cor.getDueDate();
        	String dstring = "The item is due " +dueDate.get(GregorianCalendar.HOUR_OF_DAY);
        	String ndd = (String)JOptionPane.showInputDialog(null, "Please enter change in time (hours): \n", 
        			dstring,
        			JOptionPane.PLAIN_MESSAGE);
        	int ct = Integer.parseInt(ndd);
        	dueDate.set(GregorianCalendar.HOUR_OF_DAY, (dueDate.get(GregorianCalendar.HOUR_OF_DAY)+ ct));
        	cor.setDueDate(dueDate);
        	dstring = "The item is now due at "+dueDate.get(GregorianCalendar.HOUR_OF_DAY);
        	JOptionPane.showMessageDialog(null, dstring);
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
		Key k3 = new Key(1003,202);
		Accessory bc1 = new Accessory("Battery Charger", "Camera", 3001, 24, "Shelf");
		Accessory mc1 = new Accessory("Memory Card", "Camera", 3002, 24, "Shelf");
		Accessory cc1 = new Accessory("Camera Cable", "Camera", 3003, 24, "Shelf");
		Accessory cb1 = new Accessory("Camera Battery", "Camera", 3004, 24, "Shelf");
		Accessory bh1 = new Accessory("Bike helmet", "Bike", 4001, 24, "Shelf");
		ArrayList <Accessory> A1 = new ArrayList<Accessory>();
		ArrayList <Accessory> B1 = new ArrayList<Accessory>();
		A1.add(bc1);
		A1.add(mc1);
		A1.add(cc1);
		A1.add(cb1);
		B1.add(bh1);
		Camera c1 = new Camera("Canon", A1, 2001, 24, "Shelf");
		Bike b1 = new Bike("Yellow", B1, 5001, 24, "Outside");
		CirculatingItemList cil = new CirculatingItemList(1001, k1);
		cil.addItem(1002, k2);
		cil.addItem(1003,  k3);
		cil.addItem(3001, bc1);
		cil.addItem(3002,  mc1);
		cil.addItem(3003,  cc1);
		cil.addItem(3004,  cb1);
		cil.addItem(4001, bh1);
		cil.addItem(2001,  c1);
		cil.addItem(5001, b1);
		new UserInterface(npl, cil);
	}

}