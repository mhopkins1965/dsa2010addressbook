import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class BookDisplay implements DocumentListener {
	private JFrame frame;
	private JButton addButton, editButton, removeButton;
	private JTextField searchbar;
	private JComboBox searchSetting;
	private JPanel contentPane;
	private JList list;
	private Addressbook book;
	private HelpDialog helpDialog;
	
	public static void main(String args[])
	{
		BookDisplay display = new BookDisplay();
	}
	
	public BookDisplay() {
		book = new Addressbook();
		makeFrame();
		helpDialog = new HelpDialog(); /////////////////////////vvvvvvvvvvvvvvvvvvv////////////////
	}
	
	/**
	 * Creates the right hand sidebar. Includes add, edit, remove buttons and search specifier
	 */
	private void makeSidebar(){
		JPanel sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
			/* Add Button */
		addButton = new JButton("Add");
		addButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								JDialog dialog = new NewEntryDialog(BookDisplay.this, book);
								dialog.setVisible(true);
								}
						});
		sidebar.add(addButton);
			/* Edit Button */
		editButton = new JButton("Edit");
		editButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		editButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								JDialog dialog = new NewEntryDialog(BookDisplay.this, book, (AddressEntry)list.getSelectedValue());
								dialog.setVisible(true); 
								}
						});
		sidebar.add(editButton);
			/* Remove Button */
		removeButton = new JButton("Remove");
		removeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		removeButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { removeEntry(); }
						});
		sidebar.add(removeButton);
		/*-------- Add/Edit/Remove buttons ------------*/
		
		String choices[] = {"Name", "Phone Number", "Address"};
		searchSetting = new JComboBox(choices);
		searchSetting.setMaximumSize(new Dimension(150, 100));
		searchSetting.setAlignmentX(JButton.CENTER_ALIGNMENT);
		/* end of search menu setup */
		
		sidebar.add(Box.createVerticalGlue());
		sidebar.add(new JLabel("Search by "));
		sidebar.add(searchSetting);
		
		frame.getContentPane().add(sidebar, BorderLayout.EAST);
	}
	
	/** Creates the basic setup and attempts to fill in starting data
	 * 
	 */
	public void makeFrame() {
		book.addNewEntry("a", "dfd", "dfd");
		book.addNewEntry("Tom Renn", "721", "blah");
		book.addNewEntry("Phil Apple", "dfdf", "dfdf");
		book.addNewEntry(" appled", "dfd", "fdf");
		book.addNewEntry(" app22led", "dfd", "fdf");
		book.addNewEntry(" appd1led", "dfd", "fdf");
		book.addNewEntry(" apapled", "dfd", "fdf");
		book.addNewEntry(" appddled", "dfd", "fdf");
		book.addNewEntry(" appbled", "dfd", "fdf");
		book.addNewEntry(" appeled", "dfd", "fdf");
		book.addNewEntry(" appfffled", "dfd", "fdf");
		book.addNewEntry(" apapled", "dfd", "fdf");
		book.addNewEntry(" ap3pled", "dfd", "fdf");
		book.addNewEntry(" app2led", "dfd", "fdf");
		book.addNewEntry(" ap1pled", "dfd", "fdf");
		
		book.addNewEntry("Ed Springer", "322", "meh");
		book.addNewEntry("Billy Bob Thornton", "5555555555", "Hollywood");
		
	    frame = new JFrame("Address Book 0.5");
	    frame.setMinimumSize(new Dimension(420, 300));
	    frame.setLocation(250, 150);
	    frame.setPreferredSize(new Dimension(700, 400));
	    frame.setVisible(true);
	    frame.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				updateList(null);
			}
		});
	    
	    makeMenuBar();
	    
	    contentPane = (JPanel)frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
//	    JPanel tempPane = new JPanel(new FlowLayout());

	    JLabel label = new JLabel("Search or Add Address Book Entries!");
	    label.setHorizontalAlignment(JLabel.CENTER);
//	    tempPane.add(label);
	    
	    updateList(null);
	    
	    contentPane.add(BorderLayout.NORTH, label);
	    
	    // searchbar
	    searchbar = new JTextField(); 
	    	JPanel searchPanel = new JPanel(new GridLayout(1, 3));
	    	searchPanel.setSize(400, 30);
	    	searchbar.setSize(400, 30);
	    	searchPanel.add(new JLabel("Search Entries"));
	    	searchPanel.add(searchbar);
	    searchbar.getDocument().addDocumentListener(this);
	    contentPane.add(BorderLayout.SOUTH, searchPanel);
	    makeSidebar();
	    frame.pack();
	}
	
	/* setups the menu bar */
	private void makeMenuBar() {
		final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu menu;
		JMenuItem item;
		
		menu = new JMenu("File");
		menubar.add(menu);
		
		item = new JMenuItem("Save");
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, SHORTCUT_MASK));
			item.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) { save(); }
							});
		menu.add(item);
		
		item = new JMenuItem("Quit");
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
			item.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) { quit(); }
							});
		menu.add(item);
		
		menu = new JMenu("Help");
		menubar.add(menu);
		
		item = new JMenuItem("About");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, SHORTCUT_MASK));
		item.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { showHelp(); }
							});
		menu.add(item);
	}
	
	// save the address book
	private void save() {
		book.save();
	}
	
	// quit the program
	private void quit() {
		System.exit(0);
	}
	
	// show the help dialog box
	private void showHelp() {
		helpDialog.setVisible(true);
	}
	
	// removes an entry if one is selected
	private void removeEntry() {
		if (list.getSelectedValue() != null){
			book.deleteEntry((AddressEntry)list.getSelectedValue());
			updateList(null);
		}
	}
	
	// update the list with the given entries, if null is given, all entries are displayed
	public void updateList(Object[] entries) {
		if(list == null) {
			list = new JList();
			InfoPanel infopanel = new InfoPanel();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    list.setLayoutOrientation(JList.VERTICAL_WRAP);
		    AddressEntryListListener list_listener = new AddressEntryListListener(infopanel);
		    list.addListSelectionListener(list_listener);
		    
		    list.setVisibleRowCount(-1);
		    list.setSize(300, 10);
		    contentPane.add(BorderLayout.CENTER, list);
		    contentPane.add(BorderLayout.WEST, infopanel);
		}
		
		if (entries == null)
			entries = book.getEntries();
	    list.setListData(entries);
	}

	/* Methods for search box listening */
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		
		updateList(book.search(searchbar.getText(), searchSetting.getSelectedIndex(), false));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateList(book.search(searchbar.getText(), searchSetting.getSelectedIndex(), false));
		
	}
	/* ------------------ end of search box document listening */
	

}
