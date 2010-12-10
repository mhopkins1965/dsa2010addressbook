import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class InfoPanel extends JPanel {
	JTextField nameField, phoneField, addressField;
	
	public InfoPanel(){
		nameField = new JTextField();
		phoneField = new JTextField();
		addressField =new JTextField();
		
		GridLayout layout = new GridLayout(4,1);
		this.setLayout(layout);
		
		nameField.setText("Enter your name here bitch");
		phoneField.setText("Enter your phone here");
		addressField.setText("Enter your address here");
		
		this.add(nameField);
		this.add(phoneField);
		this.add(addressField);
	}
	
	
}
