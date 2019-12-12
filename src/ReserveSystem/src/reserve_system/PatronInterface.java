package reserve_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class provides the GUI for adding a patron to the
 * "database" (PatronList map object). It is implemented
 * using a JPanel within the main UI window
 */

public class PatronInterface {

	public PatronInterface(PatronList npl, JFrame f) {
		JPanel addpat = new JPanel();
    	JLabel tl = new JLabel("Enter patron information");
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
    	JLabel cbl = new JLabel("Patron type");
	    JComboBox cb=new JComboBox(ptype);    
    	
    	
    	JButton confirm = new JButton("Confirm");
    	
    	tl.setBounds(150, 10, 200, 30);
    	fnl.setBounds(50, 50, 100, 30);
    	lnl.setBounds(50, 150, 100, 30);
    	pidl.setBounds(50, 250, 100, 30);
    	pel.setBounds(50, 350, 100, 30);
    	ppl.setBounds(50, 450, 100, 30);
    	cbl.setBounds(50, 550, 100, 30);
    	
    	fn.setBounds(150, 50, 100, 30);
    	ln.setBounds(150, 150, 100, 30);
    	pid.setBounds(150, 250, 100, 30);
    	pe.setBounds(150, 350, 100, 30);
    	pp.setBounds(150, 450, 100, 30);
    	cb.setBounds(150, 550, 100, 30);
    	
    	confirm.setBounds(250,600,100,30);
    	addpat.add(tl);
    	addpat.add(fnl);
    	addpat.add(lnl);
    	addpat.add(pidl);
    	addpat.add(pel);
    	addpat.add(ppl);
    	addpat.add(fn);
    	addpat.add(ln);
    	addpat.add(pid);
    	addpat.add(pe);
    	addpat.add(pp);
    	addpat.add(cbl);
    	addpat.add(cb);
    	addpat.add(confirm);
    	f.add(addpat);
    	
    	addpat.setSize(800,800);
    	addpat.setVisible(true);
    	
    	
    	
    	confirm.addActionListener((ActionEvent event_1)-> {
    		String pfn = fn.getText(); 
        	String pln = ln.getText(); 
        	String pidns = pid.getText(); 
        	String pem = pe.getText(); 
        	String pphs = pp.getText(); 
        	String pt = (String) cb.getSelectedItem();
    		int pidn = Integer.parseInt(pidns);
    		int pph = Integer.parseInt(pphs);
    		Patron np = new Patron(pidn, pt, pfn, pln, pem, pph);
    		npl.addPatron(pidn, np);
    		JOptionPane.showMessageDialog(null,  "Patron added", "",1);
    		f.remove(addpat);
    		f.repaint();
    	});
	}
}
