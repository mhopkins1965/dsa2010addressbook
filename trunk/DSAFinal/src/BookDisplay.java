import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;


public class BookDisplay {
	private JFrame frame;
	private Addressbook book;
	
	public static void main(String args[])
	{
		BookDisplay display = new BookDisplay();
	}
	
	public BookDisplay() {
		book = new Addressbook();
		makeFrame();
	}
		
	public void makeFrame() {
		book.addNewEntry("a", "dfd", "dfd");
		book.addNewEntry("Tom Renn", "721", "blah");
		book.addNewEntry("Phil Apple", "dfdf", "dfdf");
		book.addNewEntry(" appled", "dfd", "fdf");
		book.addNewEntry("Ed Springer", "322", "meh");
		book.addNewEntry("Billy Bob Thornton", "5555555555", "Hollywood");
		
	    frame = new JFrame("Address Book 0.5");
	    frame.setMinimumSize(new Dimension(350, 300));
//	    frame.setLocation(300,300);
	    frame.setVisible(true);
	    
	    makeMenuBar(frame);
	    
	    JPanel contentPane = (JPanel)frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
//	    JPanel tempPane = new JPanel(new FlowLayout());
//	    
	    JLabel label = new JLabel("Search or Add Address Book Entries!");
	    label.setHorizontalAlignment(JLabel.CENTER);
//	    tempPane.add(label);
	    
	    // LIST
	    Object[] entries = book.getEntries();
	    JList list = new JList(entries);
	    list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    list.setLayoutOrientation(JList.VERTICAL_WRAP);
	    list.setVisibleRowCount(-1);
	    contentPane.add(BorderLayout.CENTER, list);
	    
	    
	    contentPane.add(BorderLayout.NORTH, label);
	    frame.pack();
	}
	
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
