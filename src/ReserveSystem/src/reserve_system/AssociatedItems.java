package reserve_system;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AssociatedItems implements ActionListener {
	
	// GUI Part
    JTextArea area; JButton b; JLabel l;
	private String x;
    AssociatedItems()
    {
        // Setting the button 
    	JFrame f = new JFrame();
		l=new JLabel();  
		l.setBounds(50,25,100,30);  
		area=new JTextArea();  
		area.setBounds(50,250,200,30);  
		b=new JButton("Check Out All");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cleared and Skipped Checking Out Items", x, 1);
				l.setText("");
			}	
		});
		b.setBounds(100,300,120,30);  
		b.addActionListener(this);  
		f.add(l);f.add(area);f.add(b);  
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true); 
    }		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		l.setText("aa");	
	}	
	// Adding it to a string
	static Accessory[] items;
	public void buildList(Accessory[] accessory, CheckoutRecord checkout) 
    {
    	this.items = accessory;
    	String x = "";
    	//loop to iterate through all the accessory items
        for (int i = 0; i < items.length; i++) {
            // creating list of strings by concatenating
        	// stores the list of items in a list
            if (items[i] != null) {
                x += items[i].getName() + "\n";
            }    
        }	
    }
	// My Main Function
	public static void main(String[] args) 
	{  
		new AssociatedItems();
		//int[] items = {"Bag", "Charger", "SSD"};
		
		
		
	} 

}
