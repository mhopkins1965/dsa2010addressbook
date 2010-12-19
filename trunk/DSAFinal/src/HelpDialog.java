import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * An informative dialog that explains how to use the Addressbook
 * 
 */
public class HelpDialog extends JDialog{

	public HelpDialog(){
		this.setTitle("Help");
		this.setMinimumSize(new Dimension(400, 400));
		LayoutManager layout = new GridLayout(10, 1);//BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setLocationRelativeTo(null); 
		Font titleFont = new Font(Font.DIALOG, Font.ITALIC, 14);
		
		
		/* Adding entries */
		JLabel title = new JLabel("Adding entries to the Addressbook");
		title.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(title);
		JLabel desc = new JLabel("Adding entries are a\n\n\ns simple as click on add, and typing in the information.\n" +
				"Please note duplicate names are not allowed");
		desc.setPreferredSize(new Dimension(400, 111));
		this.add(desc);
		//this.add(Box.createVerticalStrut(30));
		
		
		/* Removing Entries */
		title = new JLabel("Remvoing entries from the Addressbook");
		title.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(title);
		this.add(new JLabel("To remove entries from the address book simply select them and click remove."));
		//this.add(Box.createVerticalStrut(30));
		
		
		/* Editing Entries */
		title = new JLabel("Editing entries in the Addressbook");
		title.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
		this.add(title);
		this.add(new JLabel("Before you edit an entry you must select the entry you wish to edit. You will" +
				" not be able to make changes to the edited entry if you change the name to one already existing"));
	}
}
