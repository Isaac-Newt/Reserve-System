package reserve_system;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class AssociatedItems extends JFrame implements ActionListener {
    
	
	Accessory[] items;
    // Adding items to an empty string
    public void buildList(Accessory[] accessory, CheckoutRecord checkout) 
    {
    	this.items = accessory;
    	String str = "";
    	//loop to iterate through all the accessory items
        for (int i = 0; i < items.length; i++) {
            //creating list of strings by concatenating
            if (items[i] != null) {
                str += items[i].getName() + "\n";
            }
        }
    }
    
    // Removing Items
    public void removeItemsAtCheckout(String name) {}
    
    // GUI Part
    JTextField tf; JFrame frame; JButton b; JLabel l;
    AssociatedItems()
    {
        // Setting the button 
        JButton b = new JButton("Check Out");
        b.setBounds(130, 100, 100, 40);
        b.addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														// Clear the List and Accept 
													}
        										  });
        // Setting the JTextField
        tf = new JTextField();
        tf.setBounds(80, 50, 100, 40);
        
        // Setting the JLabels
        l = new JLabel();
        l.setBounds(50, 150, 100, 40);
        
        add(b); add(tf);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);
    	
    }
    
    public static void main(String[] args) 
    {
    	new AssociatedItems();
    }
    
	@Override // Inherit ActionListener class
	public void actionPerformed(ActionEvent e) {
		String text = tf.getText();
		//pass
	}
  

}