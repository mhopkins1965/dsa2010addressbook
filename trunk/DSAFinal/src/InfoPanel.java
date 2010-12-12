import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class InfoPanel extends JPanel {
	JLabel nameField, phoneField, addressField;
	
	public InfoPanel(){
		nameField = new JLabel();
		phoneField = new JLabel();
		addressField = new JLabel();
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		nameField.setText("Enter your name here bitch");
		phoneField.setText("Enter your phone here");
		addressField.setText("Enter your address here");
		
		this.add(Box.createVerticalStrut(20));
		JLabel nameLabel = new JLabel("Name"); 
		nameLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(nameLabel);
		this.add(nameField);
		this.add(Box.createVerticalStrut(20));
		JLabel phoneLabel = new JLabel("Phone Number"); 
		phoneLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(phoneLabel);
		this.add(phoneField);
		this.add(Box.createVerticalStrut(20));
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(addressLabel);
		this.add(addressField);
	}
	
	/**
	 * Fill this InfoPanel with all the information from AddressEntry
	 */
	public void setInfo(AddressEntry entry)
	{
		nameField.setText(entry.getName());
		phoneField.setText(entry.getPhone());
		addressField.setText(entry.getAddress());
	}
}
