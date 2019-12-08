package reserve_system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class UserInterface {
	JMenu Circulation, PatronRecords;  //Menu 
    JMenuItem i1, i2, i3, i4, i5, i6; //Menu Items 
    UserInterface(){
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
        i1.addActionListener((ActionEvent e)->{
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please enter patron ID:\n",
                    "Item checkout",
                    JOptionPane.PLAIN_MESSAGE); 
        	//If we wanted to be fancy, we could automatically list checked out items here.
        	//Need to look up Patron, check for fine if community member
        	String bc = (String)JOptionPane.showInputDialog(null,
                    "Please enter item barcode:\n",
                    "Item checkout",
                    JOptionPane.PLAIN_MESSAGE); 
        });
        
        i2.addActionListener((ActionEvent e)->{
        	String bc = (String)JOptionPane.showInputDialog(null,
                    "Please enter item barcode:\n",
                    "Item return",
                    JOptionPane.PLAIN_MESSAGE);  
        	//Need to look up item, find checkout record, obtain patron
            });
        
        i3.addActionListener((ActionEvent e)->{
        	// need to bring up pane for data entry for search
        	JOptionPane.showMessageDialog(null, "Display dialog for search", "Search for circulating item",  1);
            });
        
        i4.addActionListener((ActionEvent e)->{
        	
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
        	
        	JButton confirm = new JButton("Confirm");
        	
        	
        	fnl.setBounds(50, 50, 100, 30);
        	lnl.setBounds(50, 150, 100, 30);
        	pidl.setBounds(50, 250, 100, 30);
        	pel.setBounds(50, 350, 100, 30);
        	ppl.setBounds(50, 450, 100, 30);
        	
        	fn.setBounds(150, 50, 100, 30);
        	ln.setBounds(150, 150, 100, 30);
        	pid.setBounds(150, 250, 100, 30);
        	pe.setBounds(150, 350, 100, 30);
        	pp.setBounds(150, 450, 100, 30);
        	
        	confirm.setBounds(500,250,100,30);
        	
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
        	ap.add(confirm);
        	
        	ap.setSize(800,800);
        	ap.setVisible(true);

        	f.add(ap);
        	f.repaint();
        	
        	
        	String pfn = fn.getText(); 
        	String pln = ln.getText(); 
        	String pidn = pid.getText(); 
        	String pem = pe.getText(); 
        	String pph = pp.getText(); 
       
        	// Need to add actionlistener for confirm.
        	
        	//Need to call patron constructor, add new patron to patronlist
            });
        
        i5.addActionListener((ActionEvent e)->{
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please patron's ID:\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE);  
        	//Need to look up Patron using ID, display current fine balance, 
        	//Ask for payment on balance, and adjust balance
        });
        
        i5.addActionListener((ActionEvent e)->{
        	String pi = (String)JOptionPane.showInputDialog(null,
                    "Please patron's ID:\n",
                    "Pay fine",
                    JOptionPane.PLAIN_MESSAGE);  
        	//Need to look up Patron using ID, obtain Record, obtain checkoutrecords, obtain circulating item
        	//Obtain item information, and display.  Will need toString for each item type.
       });
         
  		
    }
	public static void main(String[] args) {
		new UserInterface();
	}

}
