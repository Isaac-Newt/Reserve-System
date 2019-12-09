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
        	
        	JDesktopPane ap = new JDesktopPane();
        	
        	JLabel fnl = new JLabel("First Name: ");
        	JTextField fn = new JTextField("");
        	
        	JLabel lnl = new JLabel("Last Name: ");
        	JTextField ln = new JTextField("");
        	
        	JLabel pidl = new JLabel("Patron ID: ");
        	JTextField pid = new JTextField("");
        	
        	JLabel pel = new JLabel("Patron email: ");
        	JTextField pe = new JTextField("");
        	
        	JLabel ppl = new JLabel("Patron phone: ");
        	JTextField pp = new JTextField("");
        	String ptype[]={"Faculty", "Student", "Community"};        
    	    JComboBox cb=new JComboBox(ptype);    
        	
        	
        	JButton confirm = new JButton("Confirm");
        	
        	
        	fnl.setBounds(50, 50, 100, 30);
        	lnl.setBounds(50, 150, 100, 30);
        	pidl.setBounds(50, 250, 100, 30);
        	pel.setBounds(50, 350, 100, 30);
        	ppl.setBounds(50, 450, 100, 30);
        	cb.setBounds(50, 550, 100, 30);
        	
        	fn.setBounds(150, 50, 100, 30);
        	ln.setBounds(150, 150, 100, 30);
        	pid.setBounds(150, 250, 100, 30);
        	pe.setBounds(150, 350, 100, 30);
        	pp.setBounds(150, 450, 100, 30);
        	
        	confirm.setBounds(250,500,100,30);
        	
        	ap.add(fnl);
        	ap.add(lnl);
        	ap.add(pidl);
        	ap.add(pel);
        	ap.add(ppl);
        	ap.add(fn);
        	ap.add(ln);
        	ap.add(pid);
        	ap.add(pe);
        	ap.add(pp);
        	ap.add(cb);
        	ap.add(confirm);
        	
        	ap.setSize(800,800);
        	ap.setVisible(true);

        	f.add(ap);
        	f.repaint();
        	
        	
        	String pfn = fn.getText(); 
        	String pln = ln.getText(); 
        	Integer pidn = Integer.valueOf(pid.getText()); 
        	String pem = pe.getText(); 
        	Integer pph = Integer.valueOf(pp.getText()); 
        	String pt = (String) cb.getSelectedItem();
        	
        	//confirm.addActionListener((ActionEvent f)-> {
        	//	np = new Patron(pidn, pt, pfn, pln, pe, pph);
        	//	npl.addPatron(pidn, np);
        	//	ap.setVisible(false);
        	//	f.repaint();
        	//});
        	
        	
       
        	
        	
        	//Need to call patron constructor, add new patron to patronlist
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
        	Patron patron = patronList.getPatron(pid);
        	// create list of checked out items
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
