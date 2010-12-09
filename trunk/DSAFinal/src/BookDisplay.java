import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


public class BookDisplay {
	private JFrame frame;
	private Addressbook book;
	public static void main(String args[])
	{
		BookDisplay display = new BookDisplay();
		
	}
	
	public BookDisplay(){
		book = new Addressbook();
		book.addNewEntry("a", "dfd", "dfd");
		book.addNewEntry("Tom Renn", "721", "blah");
		book.addNewEntry("Phil Apple", "dfdf", "dfdf");
		book.addNewEntry(" appled", "dfd", "fdf");
		book.addNewEntry("Ed Springer", "322", "meh");
		
	    frame = new JFrame("Address Book 0.5");
	    frame.setMinimumSize(new Dimension(350, 300));
//	    frame.setLocation(300,300);
	    frame.setVisible(true);
	    
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

}
