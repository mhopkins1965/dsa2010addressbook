import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Acts as a dialog for adding new users
 * Can also be used to edit entries that already exists in the database
 * 
 * @author Tom
 */
public class NewEntryDialog extends JDialog implements ActionListener{
	private Addressbook addressbook;
	private AddressEntry entry;
	private JTextField nameField, phoneField, addressField;
	private JButton addButton, cancelButton;
	private BookDisplay display;
	
	public NewEntryDialog(BookDisplay display, Addressbook book) {
		addressbook = book;
		this.display = display;
		Container contentpane = this.rootPane.getContentPane();
		contentpane.setLayout(new GridLayout(4, 2));
		contentpane.add(new JLabel("Name:"));
		contentpane.add(nameField = new JTextField());
		contentpane.add(new JLabel("Phone Number:"));
		contentpane.add(phoneField = new JTextField());
		contentpane.add(new JLabel("Address:"));
		contentpane.add(addressField = new JTextField());
		/* add button */
		contentpane.add(addButton = new JButton("OK"));
		addButton.addActionListener(this);
		contentpane.add(cancelButton = new JButton("cancel"));
		cancelButton.addActionListener(new dialogCancelListener(this));
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setTitle("Add/Edit Entry");
	}
	
	/**
	 * Constructor for an entry we want to edit
	 */
	public NewEntryDialog(BookDisplay display, Addressbook book, AddressEntry entry){
		this(display, book);
		this.entry = entry; 
		nameField.setText(entry.getName());
		phoneField.setText(entry.getPhone());
		addressField.setText(entry.getAddress());
	}
	// display an informational message that the user cannot add another entry with the same name
	public void displayDuplicateError()
	{
		JOptionPane.showMessageDialog(this, "Entry with that name already exists", "Duplicate Entry", 
				JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	/**
	 * Acts as the action listener for the add button
	 * Once add button has been clicked, add the new or modified AddressEntry to the Addressbook
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean entryAdded = true;
		if (entry == null){ // create new entry
			entryAdded = addressbook.addNewEntry(nameField.getText(), phoneField.getText(), addressField.getText());
			if (!entryAdded)
				displayDuplicateError();
		}
		else { //in order to prevent duplicate names, we need to remove the orignal entry and the new one
			entryAdded = addressbook.addNewEntry(nameField.getText(), phoneField.getText(), addressField.getText());
			if (entryAdded) // if successful
				addressbook.deleteEntry(entry); // we can delete the old entry
			else
				displayDuplicateError();
		}
		if (entryAdded){
			display.updateList(null);
			this.dispose();
		}
	}
	
	// action listener that will close the dialog given to it, does absolutely nothing else
	private class dialogCancelListener implements ActionListener {
		JDialog dialog;
		// constructor
		public dialogCancelListener(JDialog dialog){	
			this.dialog = dialog;
		}
		// action performed on mouse click, closes the dialog
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
		
	}
}
