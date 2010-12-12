import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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


public class BookDisplay {
	private JFrame frame;
	private JButton addButton, editButton, removeButton;
	private JTextField searchbar;
	private JComboBox searchSetting;
	private Addressbook book;
	
	public static void main(String args[])
	{
		BookDisplay display = new BookDisplay();
	}
	
	public BookDisplay() {
		book = new Addressbook();
		makeFrame();
	}
		
	private void makeSidebar(){
		addButton = new JButton("Add");
		addButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		editButton = new JButton("Edit");
		editButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		removeButton = new JButton("Remove");
		removeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		/* end of button setup */
		String choices[] = {"Name", "Phone Number", "Address"};
		searchSetting = new JComboBox(choices);
		searchSetting.setMaximumSize(new Dimension(150, 100));
		searchSetting.setAlignmentX(JButton.CENTER_ALIGNMENT);
		/* end of search menu setup */
		
		JPanel sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
		sidebar.add(addButton);
		sidebar.add(editButton);
		sidebar.add(removeButton);
		sidebar.add(Box.createVerticalGlue());
		sidebar.add(new JLabel("Search by"));
		sidebar.add(searchSetting);
		
		frame.getContentPane().add(sidebar, BorderLayout.EAST);
	}
	/* setup frame and other stuff */
	public void makeFrame() {
		book.addNewEntry("a", "dfd", "dfd");
		book.addNewEntry("Tom Renn", "721", "blah");
		book.addNewEntry("Phil Apple", "dfdf", "dfdf");
		book.addNewEntry(" appled", "dfd", "fdf");
		book.addNewEntry("Ed Springer", "322", "meh");
		book.addNewEntry("Billy Bob Thornton", "5555555555", "Hollywood");
		
	    frame = new JFrame("Address Book 0.5");
	    frame.setMinimumSize(new Dimension(420, 300));
	    frame.setLocation(250, 150);
	    frame.setPreferredSize(new Dimension(700, 400));
	    frame.setVisible(true);
	    
	    makeMenuBar(frame);
	    
	    JPanel contentPane = (JPanel)frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
//	    JPanel tempPane = new JPanel(new FlowLayout());
	    /* InfoPanel creation */
	    InfoPanel infopanel = new InfoPanel();
	    JLabel label = new JLabel("Search or Add Address Book Entries!");
	    label.setHorizontalAlignment(JLabel.CENTER);
//	    tempPane.add(label);
	    
	    // LIST
	    Object[] entries = book.getEntries();
	    JList list = new JList(entries);
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list.setLayoutOrientation(JList.VERTICAL_WRAP);
	    AddressEntryListListener list_listener = new AddressEntryListListener(infopanel);
	    list.addListSelectionListener(list_listener);
	    
	    list.setVisibleRowCount(-1);
	    list.setSize(300, 10);
	    contentPane.add(BorderLayout.CENTER, list);
	    
	    
	    contentPane.add(BorderLayout.NORTH, label);
	    contentPane.add(BorderLayout.WEST, infopanel);
	    
	    // searchbar
	    searchbar = new JTextField(); 
	    	JPanel searchPanel = new JPanel(new GridLayout(1, 3));
	    	searchPanel.setSize(400, 30);
	    	searchbar.setSize(400, 30);
	    	searchPanel.add(new JLabel("Search Entries"));
	    	searchPanel.add(searchbar);
	    contentPane.add(BorderLayout.SOUTH, searchPanel);
	    makeSidebar();
	    
	    frame.pack();
	}
	
	/* setups the menu bar */
	private void makeMenuBar(JFrame frame) {
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
	}
	
	private void save() {
		book.save();
	}
	
	private void quit() {
		System.exit(0);
	}
}
