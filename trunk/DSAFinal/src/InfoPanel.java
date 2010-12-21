import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

// displays info about selected address entries
public class InfoPanel extends JPanel {
	JLabel nameField, phoneField, addressField;
	
	// constructor
	public InfoPanel(){
		nameField = new JLabel();
		phoneField = new JLabel();
		addressField = new JLabel();
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		nameField.setText("Contact name displayed here");
		phoneField.setText("Contact phone displayed here");
		addressField.setText("Contact address displayed here");
		
		this.add(Box.createVerticalStrut(20));
		JLabel nameLabel = new JLabel("Name"); 
		Font titleFont = new Font(Font.DIALOG, Font.ITALIC, 14);
		nameLabel.setFont(titleFont);
		this.add(nameLabel);
		this.add(nameField);
		this.add(Box.createVerticalStrut(20));
		JLabel phoneLabel = new JLabel("Phone Number"); 
		phoneLabel.setFont(titleFont);
		this.add(phoneLabel);
		this.add(phoneField);
		this.add(Box.createVerticalStrut(20));
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(titleFont);
		this.add(addressLabel);
		this.add(addressField);
		
	}
	
	/**
	 * Fill this InfoPanel with all the information from AddressEntry
	 */
	public void setInfo(AddressEntry entry)
	{
		if(entry == null)
			return;
		
		nameField.setText(entry.getName());
		phoneField.setText(entry.getPhone());
		addressField.setText(entry.getAddress());
	}
}
