package reserve_system;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AssociatedItems implements ActionListener {
	
	// GUI Part
    JTextArea area; JButton b, b1; JLabel l;
    AssociatedItems()
    {
        // Setting the button 
    	JFrame f = new JFrame();
		l=new JLabel();  
		l.setBounds(50,50,300,30);  
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

		f.add(l);f.add(area);f.add(b); f.add(b1);
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true); 
    }		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String text = area.getText();
		if (text.equals("Bike")) {
			l.setText("Helmet, Key");	
		} else if (text.equals("Camera")) {
			l.setText("SSD, \n Charger, \n Bag");
		} else {
				l.setText("Empty");
		}	
	}	
	// My Main Function
	public static void main(String[] args) 
	{  			
		new AssociatedItems();
	
	} 

}
