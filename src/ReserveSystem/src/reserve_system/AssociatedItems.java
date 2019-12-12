package reserve_system;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AssociatedItems implements ActionListener {
	
	
	private ArrayList<Accessory> itemList;
	
	// GUI Part
    JTextArea area; JButton b, b1; JLabel l;
    AssociatedItems(JFrame f, CirculatingItem ci, CirculatingItemList cil)
    {	
    	this.itemList = ci.getItemList();
    	String text = makeList(this.itemList);
        // Setting the button 
    	JPanel jp = new JPanel();
		l=new JLabel();  
		l.setBounds(50,50,300,30);
		l.setText(text);
		area=new JTextArea();  
		area.setBounds(50,250,200,30);  
		b=new JButton("Choose");
		b.setBounds(50,300,120,30); 
		b.addActionListener(this);
		
		b1=new JButton("Check Out Everything");
		b1.setBounds(200, 300, 120, 30);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Check Out All the Items", null, 1);
				l.setText("Empty");
				
			}	
		});

		jp.add(l);jp.add(area);jp.add(b); jp.add(b1);
		jp.setSize(400,400);  
		jp.setLayout(null);  
		jp.setVisible(true);
		f.add(jp);
    }		
    
    public String makeList(ArrayList<Accessory> a) {
    	String message = "";
		for (Accessory acc: a) {
			message += acc.getName();
		}
		return message;
	}
       
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String barCode = area.getText();
		int bc = Integer.valueOf(barCode);
		CirculatingItem i = cil.getItem(bc);
		ci.getRecord.getPatron().checkOut(i);
		
	
		
	}	
	// My Main Function
	public static void main(String[] args) 
	{  			
		new AssociatedItems(null, null, null);
	
	} 

}
