package reserve_system;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AssociatedItems implements ActionListener {
	
	
	private ArrayList<Accessory> itemList;
	private Patron patron;
	private CirculatingItem ci;
	private CirculatingItemList cil;
	
	// GUI Part
    JTextArea area; JButton b1; JLabel l;
    AssociatedItems(JFrame f, Bike ci, CirculatingItemList cil)
    {	
    	this.cil = cil;
    	this.ci = ci;
		this.patron = ci.getRecord().getpatron();	
    	this.itemList = ci.getItemList();
    	String text = makeList(this.itemList);
        // Setting the button 
    	JPanel jp = new JPanel();
		l=new JLabel();  
		l.setBounds(50,50,300,30);
		l.setText(text);
		area=new JTextArea();  
		area.setBounds(50,250,200,30); 
		
		b1=new JButton("Check Out Everything");
		b1.setBounds(200, 300, 120, 30);
		

		jp.add(l);jp.add(area);jp.add(b1);
		jp.setSize(400,400);  
		jp.setLayout(null);  
		
		f.add(jp);
		jp.setVisible(true);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Check Out All the Items", null, 1);
				l.setText("Empty");
				
			}	
		});
    }
    
    public AssociatedItems(JFrame f, Camera ci, CirculatingItemList cil) {
    	this.cil = cil;
    	this.ci = ci;
		this.patron = ci.getRecord().getpatron();
    	this.itemList = ci.getItemList();
    	String text = makeList(this.itemList);
        // Setting the button 
    	JPanel jp = new JPanel();
		l=new JLabel();  
		l.setBounds(50,50,300,30);
		l.setText(text);
		area=new JTextArea();  
		area.setBounds(50,250,200,30);  
		
		b1=new JButton("Check Out Everything");
		b1.setBounds(200, 300, 120, 30);
		

		jp.add(l);jp.add(area);jp.add(b1);
		jp.setSize(400,400);  
		jp.setLayout(null);  
		
		f.add(jp);
		System.out.println("Ho");
		jp.setVisible(true);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Check Out All the Items", null, 1);
				l.setText("Empty");
				
			}	
		});
    }
    
    public String makeList(ArrayList<Accessory> a) {
    	String message = "";
		for (Accessory acc: a) {
			message += " " + acc.getName();
		}
		return message;
	}
       
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String barCode = area.getText();
		int bc = Integer.valueOf(barCode);
		CirculatingItem i = cil.getItem(bc);
		ci.getRecord().getpatron().checkOut(i);
		patron.checkOut(i);
		
	}

}