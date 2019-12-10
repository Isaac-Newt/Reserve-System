package reserve_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatronInterface {

	public PatronInterface(JFrame f, PatronList npl) {
		
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
    	
    	confirm.addActionListener((ActionEvent event_1)-> {
    		Patron np = new Patron(pidn, pt, pfn, pln, pem, pph);
    		npl.addPatron(pidn, np);
    		ap.setVisible(false);
    		f.repaint();
    	});
    	
	}
	
}
